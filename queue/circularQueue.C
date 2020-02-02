#include<stdio.h>
#include<conio.h>
#define MAX 10

int q[MAX], startOfQueue = -1, endOfQueue = -1;

void enqueue()
{
	int data;
	if(isFull())
		printf("Queue is Full\n\n");
	else
	{
		printf("Enter Integer Value: ");
		scanf("%d",&data);
		printf("\n");
		if(startOfQueue == -1)
			startOfQueue = 0;
		if(endOfQueue == MAX - 1)
			endOfQueue = 0;
		else
			endOfQueue++;
		q[endOfQueue] = data;
	}
}

void dequeue()
{
	if(isEmpty())
		printf("Queue is Empty\n\n");
	else
	{
		if(startOfQueue == endOfQueue)
			startOfQueue = endOfQueue = -1;
		else if(startOfQueue == MAX - 1)
			startOfQueue = 0;
		else
			startOfQueue++;
	}
}

void peep()
{
	if(isEmpty())
		printf("Queue is Empty\n\n");
	else
		printf("%d\n\n",q[startOfQueue]);
}

void display()
{
	int check;
	if(isEmpty())
		printf("Queue is Empty\n\n");
	else
	{
		if(endOfQueue < startOfQueue)
		{
			check = startOfQueue;
			while(check < MAX)
			{
				printf("%d\n",q[check]);
				check++;
			}
			check = 0;
			while(check <= endOfQueue)
			{
				printf("%d\n",q[check]);
				check++;
			}
		}
		else
		{
			check = startOfQueue;
			while(check <= endOfQueue)
			{
				printf("%d\n",q[check]);
				check++;
			}
		}
		printf("\n");
	}
}

int isEmpty()
{
	if(startOfQueue == -1)
		return 1;
	else
		return 0;
}

int isFull()
{
	if(startOfQueue == 0 && endOfQueue == MAX - 1)
		return 1;
	else if(endOfQueue + 1 == startOfQueue)
		return 1;
	else
		return 0;
}

void main()
{
	int choice;
	clrscr();
	printf("-----CIRCULAR QUEUE OPERATIONS-----\n\n");
	while(1)
	{
		printf("1. Insert Element\n2. Delete Element\n3. Peep\n4. Display\n5. Quit\n\n");
		printf("Enter Your Choice: ");
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
			default: printf("Invalid Input!\n\n");
		}
	}
	getch();
}