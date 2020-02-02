#include<stdio.h>
#include<conio.h>
#define MAX 50
int queue[50], endOfQueue = -1, startOfQueue = -1;

void enqueue()
{
	int data;
	if(endOfQueue == MAX-1)
		printf("Queue is full\n");
	else
	{
		if(startOfQueue == -1)
			startOfQueue = 0;
		printf("Enter Integer Value:\n");
		scanf("%d",&data);
		endOfQueue++;
		queue[endOfQueue] = data;
	}
}

void dequeue()
{
	if(startOfQueue == -1)
		printf("Queue is empty\n");
	else if(startOfQueue>endOfQueue)
		startOfQueue = endOfQueue = -1;
	else
		startOfQueue++;
}

void peep()
{
	if(startOfQueue == -1)
		printf("Queue is empty\n");
	else
		printf("%d\n",queue[startOfQueue]);
}

void display()
{
	int check;
	if(startOfQueue == -1)
		printf("Queue is empty\n");
	else
	{
		check = startOfQueue;
		while(check <= endOfQueue)
		{
			printf("%d\n",queue[check]);
			check++;
		}
	}
}

void main()
{
	int choice;
	clrscr();
	printf("-----Linear Queue Operations-----\n");
	while(1)
	{
		printf("1. Insert\n");
		printf("2. Delete\n");
		printf("3. Peep\n");
		printf("4. Display\n");
		printf("5. Quit\n\n");
		printf("Enter Your Choice:\n");
		scanf("%d",&choice);
		printf("\n");

		switch(choice)
		{
			case 1: enqueue();
				break;
			case 2: dequeue();
				break;
			case 3: peep();
				break;
			case 4: display();
				break;
			case 5: exit(1);
				break;
			default: printf("Invalid Input\n");
		}
	}
}