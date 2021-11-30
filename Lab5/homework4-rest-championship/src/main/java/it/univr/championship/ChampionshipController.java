package it.univr.championship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ChampionshipController {

    @Autowired
    private MatchRepository matchRepository;


    @PostMapping("/match")
    public Match addMatch(@RequestBody Match match) {
        matchRepository.save(match);
        return match;
    }


    @GetMapping("/match/{matchId}")
    public Optional<Match> readBook(@PathVariable("matchId") Long id) {
        return matchRepository.findById(id);
    }


    @DeleteMapping("/match/{matchId}")
    public void deleteMatch(@PathVariable("matchId") Long id) {
        matchRepository.deleteById(id);
    }


    @PutMapping("/match/{matchId}")
    public Match updateMatch(@PathVariable("matchId") Long id, @RequestBody Match match) {

        Optional<Match> editingMatch = matchRepository.findById(id);

        if (editingMatch.isEmpty())
            System.out.println("There is no match with this ID.");
            // magari aggiungiamoci un 404 ig?

        match.setId(id);
        matchRepository.save(match);
        return match;
    }


    @GetMapping("/matches")
    public HashMap<String,Iterable<Match> >getMatches() {
        HashMap<String,Iterable<Match>> result = new HashMap<>();
        result.put("matches",matchRepository.findAll());
        return result;
    }


    @GetMapping("/matches/{teamName}")
    public HashMap<String,Iterable<Match> >getMatchesByTeam(@PathVariable("teamName") String teamName) {

        HashMap<String,Iterable<Match>> result = new HashMap<>();
        result.put("matches",matchRepository.findByTeamAOrTeamB(teamName, teamName));
        return result;
    }


    @GetMapping("/teams")
    public HashMap<String,Iterable<String>>getTeams(){
        // Use utility function to get list
        Iterable<String> teams = getTeamsList(matchRepository);

        // Build output as expected from API
        HashMap<String,Iterable<String>> result = new HashMap<>();
        result.put("teams",teams);
        return result;
    }


    @GetMapping("/ranking")
    public HashMap<String,HashMap<String,Object>> getRanking(){

        // Build ranking using utility function
        TreeSet<TeamPoints> orderedRankingSet = this.buildRanking(matchRepository);

        // Build expected output
        HashMap<String,HashMap<String,Object>> result = new HashMap<>();
        int i = 0;
        for(TeamPoints tp:orderedRankingSet){
            i++;
            //Create inner map
            HashMap<String,Object> innerResult = new HashMap<>();
            innerResult.put("team",tp.team);
            innerResult.put("points",tp.points);

            result.put(String.valueOf(i),innerResult);
        }
        return result;
    }


    @GetMapping("/winner")
    public HashMap<String,String> getWinner(){

        // Use utility function to compute ranking
        TreeSet<TeamPoints> orderedRankingSet = buildRanking(matchRepository);

        // Extract first place and build expected output
        HashMap<String,String> result = new HashMap<>();
        result.put("winner",orderedRankingSet.first().team);
        return result;
    }


    // Java HashMaps have the drawback of not being orderable by value (points). Hence, I made
    // a custom structure with a compareTo that works on points...
    private class TeamPoints implements Comparable<TeamPoints>
    {
        final String team;
        final Integer points;

        TeamPoints(String team, Integer points){
            this.team = team;
            this.points = points;
        }

        @Override
        public int compareTo(TeamPoints o) {
            return o.points - points;
        }
    }

    private static Iterable<String> getTeamsList(MatchRepository matchRepository){

        Iterable<Match> matches = matchRepository.findAll();
        HashSet<String> teams = new HashSet<String>();

        for(Match match:matches){
            teams.add(match.getTeamA());
            teams.add(match.getTeamB());
        }
        return teams;
    }

    private TreeSet<TeamPoints> buildRanking(MatchRepository matchRepository){

        // Retrieve list of distinct playing teams
        Iterable<String> teams = getTeamsList(matchRepository);
        // Initialize map to save results
        HashMap<String,Integer> points = new HashMap<>();
        for(String team:teams){
            points.put(team,0);
        }

        // Compute result for each match
        for(Match match:matchRepository.findAll()){
            if (match.computeResult().equals(Match.MatchResult.A_WINNER))
                points.put(match.getTeamA(),points.get(match.getTeamA())+3);
            else if (match.computeResult().equals(Match.MatchResult.B_WINNER))
                points.put(match.getTeamB(),points.get(match.getTeamB())+3);
            else{
                points.put(match.getTeamA(),points.get(match.getTeamA())+1);
                points.put(match.getTeamB(),points.get(match.getTeamB())+1);
            }
        }

        // Ordering the result: convert to ordered collection.
        // (final output won't be in order, but I need to know the position...)
        Set<Map.Entry<String,Integer>> pointsSet = points.entrySet();
        TreeSet<TeamPoints> orderedPointsSet = new TreeSet<TeamPoints>();
        for(Map.Entry<String,Integer> entry:pointsSet)
            orderedPointsSet.add(new TeamPoints(entry.getKey(),entry.getValue()));

        return orderedPointsSet;
    }

}

