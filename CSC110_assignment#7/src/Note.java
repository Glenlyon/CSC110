
public class Note {
	private String pitch;
	private int octave;
	private String duration;
	private static final String[][] transposeTable = {
			 {"c_", "c"},
			 {"c", "d_"},
			 {"c", "c^"},
			 {"c^", "d"},
			 {"d_", "d"},
			 {"d", "d^"},
			 {"d", "e_"},
			 {"d^", "e"},
			 {"e_", "e"},
			 {"e", "e^"},
			 {"e_", "f_"},
			 {"e", "f"},
			 {"e^", "f^"},
			 {"f", "f^"},
			 {"f", "g_"},
			 {"f^", "g"},
			 {"g", "g^"},
			 {"g", "a_"},
			 {"g^", "a"},
			 {"a_", "a"},
			 {"a", "a^"},
			 {"a", "b_"},
			 {"a^", "b"},
			 {"b_", "b"},
			 {"b_", "c_"},
			 {"b", "b^"},
			 {"b", "c"},
			 {"b^", "c^"}
			 };
	
	public Note(String pitch, String duration) {
		this.pitch = pitch;
		this.duration = duration;
	}
	
	private void transposeUp(){
		for(int i = 0; i<transposeTable.length; i++){
			if(pitch.equals(transposeTable[i][0])){
				pitch = transposeTable[i][1];
			}
		}
		if(pitch.equals("c")){
			octave++;
		}
	}
	
	private void transposeDown(){
		for(int i = 0; i<transposeTable.length; i++){
			if(pitch.equals(transposeTable[i][1])){
				pitch = transposeTable[i][0];
			}
		}
		if(pitch.equals("b")){
			octave--;
		}
	}
	
	public void transpose(int semitones){
		if(semitones<0){
			for(int i=0; i>=semitones; i--){
				transposeDown();
			}
		}else{
			for(int i=0; i<=semitones; i++){
				transposeUp();
			}
		}	
	}
	
	public String toString(){
		return pitch + octave + " "+ duration;
	}
}
