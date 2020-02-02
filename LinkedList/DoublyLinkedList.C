#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node* prev;
	struct node* next;
};

struct node* head=NULL;

struct node* new_node(int n)
{
	struct node* temp = (struct node*)malloc(sizeof(struct node));
	temp->data = n;
	temp->prev = NULL;
	temp->next = NULL;
	return temp;
}

void insertion_beginning()
{
	int n;
	struct node* newNode;
	printf("Enter Integer Value:\n");
	scanf("%d",&n);
	newNode = new_node(n);
	if(head==NULL)
		head=newNode;
	else
	{
		newNode->next=head;
		head->next->prev=newNode;
		head=newNode;
	}
}

void insertion_last()
{
	int n;
	struct node* newNode,*ptr;
	printf("Enter Integer Value:\n");
	scanf("%d",&n);
	newNode=new_node(n);
	if(head==NULL)
		head=newNode;
	else
	{
		ptr=head;
		while(ptr->next!=NULL)
		{
			ptr=ptr->next;
		}
		newNode->prev=ptr->next;
		ptr->next=newNode;
	}
}

void delete_beginning()
{
	struct node* ptr;
	if(head==NULL)
		printf("Linked list is empty\n");
	else
	{
		ptr=head;
		head=head->next;
		ptr->next=NULL;
		free(ptr);
	}
}

void delete_last()
{
	struct node* ptr;
	if(head==NULL)
		printf("No Linked List");
	else
	{
		ptr=head;
		while(ptr!=NULL)
		{
			ptr=ptr->next;
		}
		ptr->prev->next=NULL;
		ptr->prev=NULL;

	}
}

void display()
{
	struct node* ptr;
	ptr=head;
	if(head==NULL)
		printf("Linked list is empty\n");
	else
		printf("\n");
		while(ptr!=NULL)
		{
			printf("%d\n",ptr->data);
			ptr=ptr->next;
		}
}

void search()
{
	int value,j=0;
	struct node* ptr;
	ptr=head;
	printf("Enter value to search:\n");
	scanf("%d",&value);
	printf("\n");
	while(ptr!=NULL)
	{
		if(value==ptr->data)
		{
			printf("Value found!!!\n");
			j=1;
			break;
		}
		ptr=ptr->next;
	}
	if(j==0)
		printf("Value not found!!!\n");
}

void main()
{
	int choice;
	clrscr();
	printf("-----DOUBLE LINKED LIST-----\n\n");
	while(1)
	{
		printf("1. Insertion at beginning\n");
		printf("2. Insertion at last\n");
		printf("3. Delete from beginning\n");
		printf("4. Delete from last\n");
		printf("5. Display linked list\n");
		printf("6. Search in linked list\n");
		printf("7. Quit\n\n");
		printf("Enter Your Choice:\n");
		scanf("%d",&choice);

		switch(choice)
		{
			case 1: insertion_beginning();
				break;
			case 2: insertion_last();
				break;
			case 3: delete_beginning();
				break;
			case 4: delete_last();
				break;
			case 5: display();
				break;
			case 6: search();
				break;
			case 7: exit(1);
				break;
			default: printf("INVALID CREDENTIALS\n");
		}
	}
}