//B

/* array const declare */
const int arr_1[3] = {1, 2, 3};
const char brr_1[6] = {'w', 'u', 't', 'o', 'n', 'g'};
/* array declare*/
int arr_2[2] = {1, 2};
char brr_2[3] = {'z', 'h', 'w'};
/* function define */
void fun_1(int a){
	int b = a;
}

int fun_2(int a){
	return a;
}

char fun_3(char a){
	return a;
}

void fun_4(int arr[]){
	arr[2] = 9;
}

int main()
{
	/* call function with array */
	fun_1(arr_1[0]);
	int x = fun_2(arr_2[0]);
	char ch = fun_3(brr_1[0]);
	fun_4(arr_2);
	/* use array element */
		/* multExp */
	int mult_1 = arr_1[0] + arr_2[1];
	int mult_2 = arr_1[1] * arr_2[0];
	int mult_3 = arr_1[2] / arr_2[0];
	int mult_4 = arr_1[2] % arr_2[0];
	/* AddExp */
	int add_1 = arr_1[0] * arr_2[1] + arr_1[2] % arr_2[0];
	int add_2 = arr_2[1] * arr_1[2] - arr_1[1] % arr_1[0];
	/* print student No. */
	printf("22373321\n"); //student No.
	return 0;
}

