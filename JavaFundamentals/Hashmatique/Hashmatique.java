import java.util.HashMap;

class Hashmatique{
    public void tracklist(){
        HashMap<String, String> tracks = new HashMap<>();
        tracks.put("We No Who U R", "The tree dont care what the little bird sings We go down with the dew in the morning light");
        tracks.put("Albert Goes West", "Albert goes west, he crossed the vast indifferent deserts of Arizona, oh yeah He had a psychotic episode on a dude ranch that involved a bottle of ammonia");
        tracks.put("Midnight Man", "Its early in the morning and I don't know what to do Its early in the morning and I can't believe it's true Its early in the morning and its happening again I called you once, I called you twice, aint I your midnight man?");
        tracks.put("Oh my lord", "thought I'd take a walk today It's a mistake I sometimes make My children lay asleep in bed My wife lay wide-awake");
        System.out.println(tracks.get("Oh my lord")); 
        for(String key : tracks.keySet()){
            System.out.println("Track: " + key);
            System.out.println("Lyrics: " + tracks.get(key));
        }
    }   
}







