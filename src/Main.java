import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args){
		Pack[] packs = new Pack[5];

		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++){
			System.out.print("Input a package: ");
			String line = scan.nextLine();
			try {
				packs[i] = parsePack(line);
			} catch(IOException e){
				System.out.println(e.getMessage());
			}
		}

		Arrays.sort(packs);
		for(int i=0; i<5; i++){
			System.out.println(packs[i]);
		}

	}

	private static Pack parsePack(String line) throws IOException{
		String[] params = line.split(",");
		String type = params[0];
		String newReceiver = params[1];
		String newZone = params[2];
		String[] date = params[3].split("/");
		int month = Integer.parseInt(date[0]);
		int day = Integer.parseInt(date[1]);
		int year = Integer.parseInt(date[2]);
		int newWeight = Integer.parseInt(params[4]);
		int newVolume = Integer.parseInt(params[5]);

		Date newDate = new Date(month, day, year);

		if (type.equalsIgnoreCase("R")) {
			return new Pack(newReceiver, newZone, newDate, newWeight, newVolume);
		} else if (type.equalsIgnoreCase("S")) {
			int newTime = Integer.parseInt(params[6]);
			return new SpecPack(newReceiver, newZone, newDate, newWeight, newVolume, newTime);
		}
		throw new IOException("The line was not the correct format.");
	}
}