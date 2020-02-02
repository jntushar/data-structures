#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node* next;
	struct node* prev;
};

struct node* head = NULL;
struct node* tail = NULL;

struct node* new_node(int n)
{
	struct node* temp = (struct node*)malloc(sizeof(struct node));
	temp->data = n;
	temp->next = NULL;
	temp->prev = NULL;
	return temp;
}

void InsertionBeginning()
{
	int n;
	struct node* newNode;
	printf("Enter integer value:\n");
	scanf("%d",&n);
	newNode = new_node(n);
	if(head==NULL)
	{
		head = newNode;
		tail = newNode;
		head->next = newNode;
		head->prev = newNode;
	}
	else
	{
		head->prev = newNode;
		newNode->next = head;
		head = newNode;
		newNode->prev = tail;
		tail->next = newNode;
	}
}

void InsertionLast()
{
	int n;
	struct node* newNode;
	printf("Enter integer value:\n");
	scanf("%d",&n);
	newNode=new_node(n);
	if(head==NULL)
	{
		head = newNode;
		tail = newNode;
		head->next = newNode;
		head->prev = newNode;
	}
	else
	{
		newNode->next=head;
		head->prev=newNode;
		tail->next=newNode;
		newNode->prev=tail;
		tail=newNode;
	}
}

void DeleteBeginning()
{
	struct node* ptr;
	if(head==NULL)
		printf("Linked List is empty\n");
	else
	{
		ptr=head;
		tail->next=head->next;
		head->next->prev=tail;
		head=head->next;
		ptr->next=NULL;
		ptr->prev=NULL;
		free(ptr);
	}
}

void DeleteLast()
{
	struct node* ptr;
	if(head==NULL)
		printf("Linked List is empty");
	else
	{
		ptr=tail;
		head->prev=tail->prev;
		tail->prev->next=head;
		tail=tail->prev;
		ptr->next=NULL;
		ptr->prev=NULL;
		free(ptr);
	}
}

void Display()
{
	struct node* ptr;
	if(head==NULL)
		printf("Linked List is empty\n");
	else
	{
		ptr=head;
		while(ptr->next!=head)
		{
			printf("%d\n",ptr->data);
			ptr=ptr->next;
		}
		printf("%d\n",ptr->data);
		printf("Tail data = %d\n",tail->data);
	}
}

void Search()
{
	int value,j=0;
	struct node* ptr;
	printf("Enter value to search:\n");
	scanf("%d",&value);
	printf("\n");
	ptr=head;
	while(ptr->next!=head)
	{
		if(ptr->data==value)
		{
			printf("Value Found\n");
			j=1;
			break;
		}
		ptr=ptr->next;
	}
	if(ptr->data==value)
	{
		printf("Value Found\n");
		j=1;
	}
	if(j==0)
		printf("Value not found\n");
}

void main()
{
	int choice;
	clrscr();
	printf("-----Circular Double Linked List-----\n\n");
	while(1)
	{
		printf("1. Insertion at beginning\n");
		printf("2. Insertion at last\n");
		printf("3. Delete from beginning\n");
		printf("4. Delete from last\n");
		printf("5. Display Linked List\n");
		printf("6. Search\n");
		printf("7. Quit\n\n");
		printf("Enter your choice:\n");
		scanf("%d",&choice);
		printf("\n");

		switch(choice)
		{
			case 1: InsertionBeginning();
				break;
			case 2: InsertionLast();
				break;
			case 3: DeleteBeginning();
				break;
			case 4: DeleteLast();
				break;
			case 5: Display();
				break;
			case 6: Search();
				break;
			case 7: exit(1);
				break;
			default: printf("Invalid Input\n");
		}
	}
}