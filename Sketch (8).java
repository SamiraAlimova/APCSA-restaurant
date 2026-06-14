import java.util.ArrayList;
import processing.core.PApplet;
import java.util.Scanner;
import java.io.File;

public class Sketch extends PApplet {
    ArrayList<Restaurant> top2024 = new ArrayList<Restaurant>();
    ArrayList<Restaurant> top2025 = new ArrayList<Restaurant>();

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    try {

    //The 2024 bucket
      Scanner sc24 = new Scanner(new File("restaurants2024.txt"));

      // loop through each line of the file
      while (sc24.hasNextLine()) {
        String line = sc24.nextLine();

        String[] arr = line.split(","); //spliting them
        
        int rank = Integer.parseInt(arr[0]); //Data from array
        String name = arr[1].trim();
        String causine = arr[2].trim();
        

      top2024.add(new Restaurant(rank, name, causine));
    

      }
    sc24.close();

    //The 2025 bucket
    Scanner sc25 = new Scanner(new File("restaurants2025.txt"));
    while (sc25.hasNextLine()) {
        String line = sc25.nextLine();
        String[] arr = line.split(",");

        int rank = Integer.parseInt(arr[0].trim());
        String name = arr[1].trim();
        String causine = arr[2].trim();

        top2025.add(new Restaurant(rank, name, causine));
    }
    sc25.close();
        
        //comparison
        println("___Restaurants that moved up___");
        for (Restaurant resta25 : top2025) {
            for (Restaurant resta24 : top2024) {
                //if names will match check is there any impoved from 2025 rank < 2025 rank
                if (resta25.getName().equals(resta24.getName())) {
                    if (resta25.getRank() < resta24.getRank()) {
                        int jumpFrom = resta24.getRank() - resta25.getRank();
                        println(resta25.getName() + " moved up by " + jumpFrom + " spots! ");
                    }
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }
  }

  public void draw() {
    
  }
}