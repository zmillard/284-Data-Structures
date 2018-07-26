public class creditOffer
{
	public double membershipFee; //dollars per year
	public double CBR; //cash back rate
	public double APR; //annual interest rate

	public void creditOffer(double fee, double cbr, double apr)
	{
		membershipFee = fee;
		CBR = cbr;
		APR = apr;
	}
	public double getScore(double expenses){
		return (CBR/100 * expenses) - membershipFee - (APR/100 * expenses);
	}
}