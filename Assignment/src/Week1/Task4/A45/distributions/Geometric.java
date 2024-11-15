package Week1.Task4.A45.distributions;

/** A random number generator based on the geometric distribution.
 * automatically generated by the <code>MetaGenerator</code> 
 * @version 1.0, Thu Oct 03 10:27:38 BST 2002
 * @author F.Mallet from C.Simatos's original
 */

public class Geometric extends Generator implements DiscreteGenerator {
    private double prob;
    /**
     * the seed is aumatically provided by the <code>SeedGenerator</code>
     */
    public Geometric(double prob) {
        super();
        set(prob);
    }

    /**
     * The constructor with which a specific seed is set for the random
     * number generator
     * @param seed The initial seed for the generator, two instances with
     *             the same seed will generate the same sequence of numbers
     */
    public Geometric(double prob, long seed) {
	super(seed);
	set(prob);
    }

    private void set(double prob) {
        if (prob<=0 || prob>=1)
            throw new ParameterException("Geometric: The probability of success must be between 0 and 1.");
        this.prob = prob;
    }

    /**
     * Generate a new random number.
     * @return The next random number in the sequence
     */
    public long sample() { 
         return distrib.geometric(prob);
    }
}
