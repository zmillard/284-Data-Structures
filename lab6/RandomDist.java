public static void main(String[]args){
	Random rand = new Random();
	for (int i = 0; i < 5; i++){
		System.out.print(rand.nextFloat() + " ");
	}

	System.out.println();

	Random rand2 = new Random();

	float LAMDA = 3f;
	for(int i; i < 5; ++i){
		System.out.pring(-Math.log((rand2.nextFloat() + 1)/LAMDA))
	}
}