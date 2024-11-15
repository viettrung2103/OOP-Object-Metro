package Week1.Task4.A45.assignment;


import Week1.Task4.A45.distributions.Normal;

public class ServeProcess {
    private static final double meanQueue = 1;
    private static final double meanSPX = 4;
    private static final double meanSPY = 7;
    private static final double variable = 1;
    private static final long defaultSeed = 123;
    private double mean;


    private Normal timeGenerator;

    public ServeProcess() {
//        this.timeGenerator = new Normal(getM)
    }

    public void setMean(ServicePoint servicePoint) {
        ServicePointType sp = servicePoint.getServicePointType();
        switch (sp) {
            case SPX -> this.mean = meanSPX;
            case SPY -> this.mean = meanSPY;
            case QUEUE -> this.mean = meanQueue;
        }
    }

    public void createTimeGenerator(ServicePoint servicePoint) {
        setMean(servicePoint);
        long seed = System.currentTimeMillis() & 0xfffff;
//        System.out.println("Seed: "+seed);
//        this.timeGenerator = new Normal(this.mean, this.variable, defaultSeed);
        this.timeGenerator = new Normal(this.mean, this.variable, seed);
    }

    public double generateServeTime(ServicePoint servicePoint) {
        double time ;
        this.createTimeGenerator(servicePoint);
//        return Math.ceil(this.timeGenerator.sample());
        do {
            time = Math.ceil(this.timeGenerator.sample());
        } while (time <= 0);

        return Math.ceil(time);
    }

    public static void main(String[] args) {
//        ServeProcess serveProcess = new ServeProcess();
//        ServicePoint servicePoint = new ServicePoint(ServicePointType.QUEUE);
//
//        for (int i = 0; i <= 10; i++) {
//            double serveTime = serveProcess.generateServeTime(servicePoint);
//            System.out.println("serve time " + serveTime);
//        }
    }
}

