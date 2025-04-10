import java.util.*;
public class Sound
{
  /** the array of values in this sound; guaranteed not to be null */
  int[] samples;



  /** Changes those values in this sound that have an amplitude greater than limit.
   *  Values greater than limit are changed to limit.
   *  Values less than -limit are changed to -limit.
   *  @param limit the amplitude limit
   *         Precondition: limit >= 0
   *  @return the number of values in this sound that this method changed
   */
  public int limitAmplitude(int limit)
{
  int count = 0;
  for (int i = 0; i < samples.length; i++) {
    if (samples[i] > limit) {
      samples[i] = limit;
      count++;
    } else if (samples[i] < -limit) {
      samples[i] = -limit;
      count++;
    }
  }
  return count;
}

public void trimSilenceFromBeginning()
{
  int firstNonZero = 0;
  while (samples[firstNonZero] == 0) {
    firstNonZero++;
  }
  int[] newSamples = new int[samples.length - firstNonZero];
  for (int i = 0; i < newSamples.length; i++) {
    newSamples[i] = samples[i + firstNonZero];
  }
  samples = newSamples;
}
