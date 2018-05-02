package hackerearth;

import hackerearth.io.InputReader;
import hackerearth.io.OutputWriter;

import java.io.IOException;

/**
 * Raj and Rahul have been friends for a long time. They love playing games in their leisure time.
 *
 * <p>Today they are playing Catch and Win. In this game, Raj is standing at the roof of his house.
 * His house is H feet high. Raj is having a cricket ball with him. Rahul, on the other hand, is
 * standing on the streets at a distance X feet from Raj's house. Raj drops the ball vertically down
 * from his roof and Rahul would run towards Raj's house and try to catch it. Rahul runs at a speed
 * of Z feet per second. If Rahul is able to catch the ball before or at the moment the ball hits
 * the ground he wins else Raj wins.
 *
 * <p>Given H, X and Z determine who wins the game.
 *
 * <p>Note:
 *
 * <p>Consider acceleration due to gravity to be 32 feet per second squared.
 *
 * <p>Input:
 *
 * <p>First line contains T denoting the number of test cases. Each test case then contains 3
 * integers namely H, X and Z respectively.
 *
 * <p>Output:
 *
 * <p>For each test case output whether Raj wins or Rahul.
 *
 * <p>Constraints:
 *
 * <p>1<=T<=100
 *
 * <p>1<=H, X, Z<=10 power 6
 */
public class MayEasy18BlotSpeed {

  static final String RAHUL_WINS = "Rahul";
  private static final double GRAVITATIONAL_PULL = 32.0;
  private static final String RAJ_WINS = "Raj";
  private final OutputWriter outputWriter;

  private InputReader inputReader;

  public MayEasy18BlotSpeed(InputReader inputReader, OutputWriter outputWriter) {

    this.inputReader = inputReader;
    this.outputWriter = outputWriter;
  }

  public String calculate() throws IOException {

    int numberOfTestCases = inputReader.nextInt();

    String winner = "";
    while (numberOfTestCases-- > 0) {

      int heightOfBuilding = inputReader.nextInt();
      int distanceFromBuilding = inputReader.nextInt();
      int runningSpeed = inputReader.nextInt();
      int timeTakenByBallToReachGround =
              Double.valueOf(
                      Math.ceil(Integer.valueOf(heightOfBuilding).doubleValue() / GRAVITATIONAL_PULL))
                      .intValue();
      int timeTakenToReachTheBuilding =
              Double.valueOf(
                      Math.ceil(
                              Integer.valueOf(distanceFromBuilding).doubleValue()
                                      / Integer.valueOf(runningSpeed).doubleValue()))
                      .intValue();
      winner = timeTakenByBallToReachGround < timeTakenToReachTheBuilding ? RAJ_WINS : RAHUL_WINS;
      if (outputWriter != null) {
        outputWriter.println(winner);
      }
    }

    return winner;
  }
}
