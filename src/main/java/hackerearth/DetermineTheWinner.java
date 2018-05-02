package hackerearth;

import java.util.Scanner;

/**
 * Assume there are two programmers with their hacker names as "Flash" and "Cisco". They both took
 * part in a contest. The rules of the contest are:
 *
 * <p>There will be 4 questions to solve, P, Q, R and S. Initial score (before the start of the
 * contest) of the 4 problems is s_p, s_q, s_r and s_s. After each minutes, the score of the
 * questions, P, Q, R and S, will decrease by d_p, d_q, d_r and d_s respectively. The score cannot
 * decrease below half (integer division) of the initial score for each question i.e. at a
 * particular time, the score of the problems will be maximum of half of the initial score and the
 * decreased score.
 *
 * <p>Flash submitted the solutions of the questions at time f_p, f_q, f_r and f_s. Cisco submitted
 * the solutions of the questions at time c_p, c_q, c_r and c_s. Your task is to find winner of
 * contest. The winner is the one who has more score. If the score of both the programmers is same,
 * then winner will be the one who took less time to solve all the questions. If both the problems
 * have same score and took same time to solve the questions, then print Tie.
 *
 * <p>NOTE: All the times mentioned above are in minutes. Time taken to solve all the questions is
 * the time at which programmers submitted the last solution.
 *
 * <p>Input Format
 *
 * <p>First line of input contains an integer T, denoting number of test cases.
 *
 * <p>First line of each test case contains 4 space separated integers s_p, s_q, s_r, s_s denoting
 * the initial scores for each problems.
 *
 * <p>Second line of each test case contains 4 space separated integers d_p, d_q, d_r, d_s denoting
 * the decrease in each problem's score after each minute.
 *
 * <p>Third line of each test case contains 4 space separated integers f_p, f_q, f_r, f_s denoting
 * the time when Flash submitted his solutions.
 *
 * <p>Fourth line of each test case contains 4 space separated integers c_p, c_q, c_r, c_s denoting
 * the time when Cisco submitted his solutions.
 *
 * <p>Output Format
 *
 * <p>Print the winner of the competition - Flash or Cisco. If both the problems have same score and
 * took same time to solve the questions, then print Tie.
 *
 * <p>Constraints
 *
 * <p>1 <= T <= 105
 *
 * <p>100 <= s_p, s_q, s_r, s_s <= 106
 *
 * <p>0 <= d_p, d_q, d_r, d_s <= 106
 *
 * <p>0 <= f_p, f_q, f_r, f_s <= 106
 *
 * <p>0 <= c_p, c_q, c_r, c_s <= 106
 */
public class DetermineTheWinner {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in, "UTF-8");
    int numnberOfTestCases = scanner.nextInt();
    while (numnberOfTestCases-- > 0) {

      int initialScoreForQuestionP = scanner.nextInt();
      int initialScoreForQuestionQ = scanner.nextInt();
      int initialScoreForQuestionR = scanner.nextInt();
      int initialScoreForQuestionS = scanner.nextInt();
      int decreaseRateForQuestionP = scanner.nextInt();
      int decreaseRateForQuestionQ = scanner.nextInt();
      int decreaseRateForQuestionR = scanner.nextInt();
      int decreaseRateForQuestionS = scanner.nextInt();
      int timeFlashTookForQuestionP = scanner.nextInt();
      int timeFlashTookForQuestionQ = scanner.nextInt();
      int timeFlashTookForQuestionR = scanner.nextInt();
      int timeFlashTookForQuestionS = scanner.nextInt();
      int timeCiscoTookForQuestionP = scanner.nextInt();
      int timeCiscoTookForQuestionQ = scanner.nextInt();
      int timeCiscoTookForQuestionR = scanner.nextInt();
      int timeCiscoTookForQuestionS = scanner.nextInt();

      int flashFinalScoreForQuestionP =
          Math.max(
              initialScoreForQuestionP / 2,
              initialScoreForQuestionP - (decreaseRateForQuestionP * timeFlashTookForQuestionP));
      int flashFinalScoreForQuestionQ =
          Math.max(
              initialScoreForQuestionQ / 2,
              initialScoreForQuestionQ - (decreaseRateForQuestionQ * timeFlashTookForQuestionQ));
      int flashFinalScoreForQuestionR =
          Math.max(
              initialScoreForQuestionR / 2,
              initialScoreForQuestionR - (decreaseRateForQuestionR * timeFlashTookForQuestionR));
      int flashFinalScoreForQuestionS =
          Math.max(
              initialScoreForQuestionS / 2,
              initialScoreForQuestionS - (decreaseRateForQuestionS * timeFlashTookForQuestionS));
      int flashFinalScore =
          flashFinalScoreForQuestionP
              + flashFinalScoreForQuestionQ
              + flashFinalScoreForQuestionR
              + flashFinalScoreForQuestionS;

      int ciscoFinalScoreForQuestionP =
          Math.max(
              initialScoreForQuestionP / 2,
              initialScoreForQuestionP - (decreaseRateForQuestionP * timeCiscoTookForQuestionP));
      int ciscoFinalScoreForQuestionQ =
          Math.max(
              initialScoreForQuestionQ / 2,
              initialScoreForQuestionQ - (decreaseRateForQuestionQ * timeCiscoTookForQuestionQ));
      int ciscoFinalScoreForQuestionR =
          Math.max(
              initialScoreForQuestionR / 2,
              initialScoreForQuestionR - (decreaseRateForQuestionR * timeCiscoTookForQuestionR));
      int ciscoFinalScoreForQuestionS =
          Math.max(
              initialScoreForQuestionS / 2,
              initialScoreForQuestionS - (decreaseRateForQuestionS * timeCiscoTookForQuestionS));
      int ciscoFinalScore =
          ciscoFinalScoreForQuestionP
              + ciscoFinalScoreForQuestionQ
              + ciscoFinalScoreForQuestionR
              + ciscoFinalScoreForQuestionS;

      int totalTimeTookByFlash =
          timeFlashTookForQuestionP
              + timeFlashTookForQuestionQ
              + timeFlashTookForQuestionR
              + timeFlashTookForQuestionS;
      int totalTimeTookByCisco =
          timeCiscoTookForQuestionP
              + timeCiscoTookForQuestionQ
              + timeCiscoTookForQuestionR
              + timeCiscoTookForQuestionS;

      if (flashFinalScore == ciscoFinalScore) {

        if (totalTimeTookByFlash == totalTimeTookByCisco) {

          System.out.println("Tie");
        } else if (totalTimeTookByCisco < totalTimeTookByFlash) {

          System.out.println("Cisco");
        } else if (totalTimeTookByCisco > totalTimeTookByFlash) {

          System.out.println("Flash");
        }
      } else if (flashFinalScore > ciscoFinalScore) {

        System.out.println("Flash");
      } else if (flashFinalScore < ciscoFinalScore) {

        System.out.println("Cisco");
      }
    }
  }
}
