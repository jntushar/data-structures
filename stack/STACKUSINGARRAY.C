#include<stdio.h>
#include<conio.h>

int stack[20], top = -1, max_size = 20;

void push()
{
	int item;
	printf("Enter Integer Value:\n");
	scanf("%d",&item);
	if(top == max_size)
		printf("Stack Overflow\n");
	else
	{
		top = top + 1;
		stack[top] = item;
	}
}

void pop()
{
	if(top == -1)
		printf("Stack is empty\n");
	else
	{
		printf("% is deleted from stack\n",stack[top]);
		top = top - 1;
	}
}

void peep()
{
	if(top == -1)
		printf("Stack is empty\n");
	else
		printf("Top of stack = %d\n",stack[top]);
}

void display()
{
	int check;
	if(top == -1)
		printf("Stack is empty\n");
	else
	{
		check=top;
		while(check != -1)
		{
			printf("%d\n",stack[check]);
			check = check - 1;
		}
	}
}

void main()
{
	int choice;
	clrscr();
	while(1)
	{
		printf("1. Push\n");
		printf("2. Pop\n");
		printf("3. Peep\n");
		printf("4. Display\n");
		printf("5. Quit\n\n");
		printf("Enter Your Choice\n");
		scanf("%d",&choice);
		printf("\n");

		switch(choice)
		{
			case 1: push();
				break;
			case 2: pop();
				break;
			case 3: peep();
				break;
			case 4: display();
				break;
			case 5: exit(1);
				break;
			default: printf("Invlaid Input\n");
		}
	}
}