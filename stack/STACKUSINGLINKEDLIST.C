#include<stdio.h>
#include<conio.h>

struct node
{
	int data;
	struct node* next;
};

struct node* head=NULL;
struct node* new_node(int n)
{
	struct node* temp = (struct node*)malloc(sizeof(struct node));
	temp->data=n;
	temp->next=NULL;
	return temp;
}

void push()
{
	int n;
	struct node* newNode;
	printf("Enter Integer Value:\n");
	scanf("%d",&n);
	newNode=new_node(n);
	if(head==NULL)
		head=newNode;
	else
	{
		newNode->next=head;
		head=newNode;
	}
}

void pop()
{
	struct node* ptr;
	if(head==NULL)
		printf("Stack is empty\n");
	else
	{
		ptr=head;
		head=head->next;
		ptr->next=NULL;
		free(ptr);
	}
}

void peep()
{
	if(head==NULL)
		printf("Stack is empty\n");
	else
		printf("%d\n",head->data);
}

void display()
{
	struct node* ptr=head;
	if(head==NULL)
		printf("Stack is empty\n");
	else
	{
		while(ptr!=NULL)
		{
			printf("%d\n",ptr->data);
			ptr=ptr->next;
		}
	}
}

void main()
{
	int choice;
	clrscr();
	printf("-----Stack Operations using Linked list-----\n\n");
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
			default: printf("Invalid Input\n");
		}
	}
}