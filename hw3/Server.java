/*
*Zoe Millard
*This method establishs the server, which can be implemented in other classes
*/
public class Server{
	private boolean idle;
    int currFr;
	public Server(){
		idle  = true;
		currFr = 0;
	}
	public boolean isIdle(){
		return idle;
	}
	public void setIdle(){}
	public void setBusy(){}
}