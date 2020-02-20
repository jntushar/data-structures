#include<stdio.h>
#include<conio.h>
#define MAX 10

//Descending Order Priority Queue

struct item
{
	int data;
	int priority;
}pQueue[MAX];

int startOfQueue = -1, endOfQueue = -1;


void enqueue()
{
	int data, priority;
	if(endOfQueue == MAX - 1)
		printf("Queue is Full\n\n");
	else
	{
		if(startOfQueue == -1 && endOfQueue == -1)
			startOfQueue = 0;
		printf("Enter Integer value: ");
		scanf("%d",&data);
		printf("Enter Priority value: ");
		scanf("%d",&priority);
		endOfQueue++;
		pQueue[endOfQueue].data = data;
		pQueue[endOfQueue].priority = priority;
	}
}

void dequeue()
{
	int pri,x;
	if(startOfQueue == -1 || endOfQueue == -1)
		printf("Queue is Empty\n");
	else
	{
		pri = findMax();
		printf("%d is deleted with highest priority = %d",pQueue[pri].data,pQueue[pri].priority);
		for(x = pri;x<=endOfQueue;x++)
		{
			pQueue[x].data = pQueue[x+1].data;
			pQueue[x].priority = pQueue[x+1].priority;
		}
		endOfQueue--;
	}
}

void highestPriority()
{
	int pri;
	if(startOfQueue == -1 || endOfQueue == -1)
		printf("Queue is empty\n");
	else
	{
		pri = findMax();
		printf("Highest priority element is %d with priority = %d\n",
		pQueue[pri].data,pQueue[pri].priority);
	}
}
int findMax()
{
	int max = pQueue[startOfQueue].priority, x;
	for(x = startOfQueue;x<=endOfQueue;x++)
	{
		if(pQueue[x].priority > max)
			max = pQueue[x].priority;
	}

	//Index of highest priority element, using linear search
	for(x = startOfQueue;x<=endOfQueue;x++)
	{
		if(max == pQueue[x].priority)
			break;
	}
	return x;
}

void display()
{
	int x;
	if(startOfQueue == -1)
		printf("Queue is empty\n\n");
	else
	{
		printf("Data\tPriority\n");
		for(x=startOfQueue;x<=endOfQueue;x++)
		{
			printf("%d\t%d\n",pQueue[x].data,pQueue[x].priority);
		}
	}
}

void main()
{
	int choice;
	clrscr();
	printf("-----PRIORITY QUEUE OPERATIONS-----\n\n");
	while(1)
	{
		printf("\nEnter Your Choice\n\n");
		printf("1. Enter an element\n");
		printf("2. Delete an element\n");
		printf("3. See highest priority element\n");
		printf("4. Display the queue\n");
		printf("5. Quit\n\n");
		scanf("%d",&choice);
		printf("\n");

		switch(choice)
		{
			case 1: enqueue();
				break;
			case 2: dequeue();
				break;
			case 3: highestPriority();
				break;
			case 4: display();
				break;
			case 5: exit(1);
				break;
			default: printf("Invalid Input!");
		}
	}
}
