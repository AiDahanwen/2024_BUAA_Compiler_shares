//A

/* global value */
int a_1 = 0;

/* function define */
int fun_1(){
	a_1 = a_1 + 1;
	return 1;
} 


int main()
{
	if(0 && fun_1()){
		;
	}
	printf("%d\n",a_1); //0
	if(1 || fun_1()){
		;
	}
	printf("%d\n", a_1); //0
	printf("22373321\n");
	return 0;
}

