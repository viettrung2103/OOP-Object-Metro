package distribution;

/** A random number generator based on the invgamma distribution.
  * automatically generated by <code>MetaGenerator</code> 
  * @version 1.0, Thu Oct 03 10:44:05 BST 2002
  * @author F.Mallet from C.Simatos's original
  */

public class Invgamma extends Generator implements ContinuousGenerator {
    private double scale;
    private double shape;
    /**
     * the seed is aumatically provided by the <code>SeedGenerator</code>
     */
    public Invgamma(double scale, double shape) {
        super();
        set(scale, shape);
    }

    /**
     * The constructor with which a specific seed is set for the random
     * number generator
     * @param seed The initial seed for the generator, two instances with
     *             the same seed will generate the same sequence of numbers
     */
    public Invgamma(double scale, double shape, long seed) {
	    super(seed);
	    set(scale, shape);
    }

    private void set(double scale, double shape) {
        if (scale <= 0.0 || shape <= 0.0)
            throw new ParameterException("Invgamma: The scale and shape parameters must be greater than 0.");
        this.scale = scale;
        this.shape = shape;
    }

    /**
     * Generate a new random number.
     * @return The next random number in the sequence
     */
    public double sample() { 
         return distrib.invgamma(scale, shape);
    }
}
