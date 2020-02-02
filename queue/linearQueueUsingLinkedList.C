#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node* next;
}*head = NULL;

struct node* newNode(int n)
{
	struct node* temp = (struct node*)malloc(sizeof(struct node));
	temp->data = n;
	temp->next = NULL;
	return temp;
}

void enqueue()
{
	int n;
	struct node* new_node, *ptr;
	printf("Enter Integer Value: ");
	scanf("%d",&n);
	new_node = newNode(n);
	if(head == NULL)
		head = new_node;
	else
	{
		ptr = head;
		while(ptr->next!=NULL)
			ptr = ptr->next;
		ptr->next = new_node;

	}
}

void dequeue()
{
	struct node* ptr;
	if(head == NULL)
		printf("Queue is Empty\n\n");
	else
	{
		ptr = head;
		head = ptr->next;
		ptr->next = NULL;
		free(ptr);
	}
}

void peep()
{
	if(head == NULL)
		printf("Queue is Empty\n\n");
	else
		printf("%d\n\n",head->data);
}

void display()
{
	struct node* ptr;
	if(head == NULL)
		printf("Queue is Empty\n\n");
	else
	{
		ptr = head;
		while(ptr!=NULL)
		{
			printf("%d\n",ptr->data);
			ptr = ptr->next;
		}
		printf("\n");
	}
}

void main()
{
	int choice;
	clrscr();
	printf("-----QUEUE IMPLEMENTATION USING LINKED LIST-----\n\n");
	while(1)
	{
		printf("1. Insert\n2. Delete\n3. Peep\n4. Display\n5. Quit\n\n");
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
}