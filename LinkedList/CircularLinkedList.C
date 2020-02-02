#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct node
{
	int data;

	struct node* next;
};

struct node* head=NULL;
struct node* tail=NULL;

struct node* new_node(int n)
{
	struct node* temp=(struct node*)malloc(sizeof(struct node));
	temp->data=n;
	temp->next=NULL;
	return temp;
}

void InsertionBeginning()
{
	int n;
	struct node* newNode;
	printf("Enter Integer Value:\n");
	scanf("%d",&n);
	newNode=new_node(n);
	if(head==NULL)
	{
		head=newNode;
		tail=newNode;
		newNode->next=newNode;
	}
	else
	{
		newNode->next=head;
		head=newNode;
		tail->next=newNode;
	}
}

void InsertionLast()
{
	int n;
	struct node* newNode;
	printf("Enter Integer Value:\n");
	scanf("%d",&n);
	newNode=new_node(n);
	if(head==NULL)
	{
		head=newNode;
		tail=newNode;
		newNode->next=newNode;
	}
	else
	{
		tail->next=newNode;
		newNode->next=head;
		tail=newNode;
	}
}

void InsertSpecificLocation()
{
	int n,nodeNumber,count=1;
	struct node* newNode,*ptr;
	printf("Enter Node Number:\n");
	scanf("%d",&nodeNumber);
	printf("Enter Integer Value:\n");
	scanf("%d",&n);
	newNode=new_node(n);
	ptr=head;
	while(ptr->next!=head)
	{
		if(count==nodeNumber-1)
		{
			newNode->next=ptr->next;
			ptr->next=newNode;
		}
		count++;
		ptr=ptr->next;
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
		head=ptr->next;
		ptr->next=NULL;
		tail->next=head;
		free(ptr);
	}
}

void DeleteLast()
{
	struct node* ptr,*prev;
	if(head==NULL)
		printf("Linked List is empty\n");
	else
	{
		ptr=head;
		while(ptr->next!=head)
		{
			prev=ptr;
			ptr=ptr->next;
		}
		ptr->next=NULL;
		prev->next=head;
		tail=prev;
		free(ptr);
	}
}

void DeleteSpecificLocation()
{
	int nodeNumber,count=1;
	struct node* ptr,*prev;
	printf("Enter node number you want to delete:\n");
	scanf("%d",&nodeNumber);
	ptr=head;
	while(ptr!=NULL)
	{
		if(count==nodeNumber)
		{
			prev->next=ptr->next;
			ptr->next=NULL;
			tail=prev;
			free(ptr);
		}
		count++;
		prev=ptr;
		ptr=ptr->next;
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
	printf("Enter Value to be searched:\n");
	scanf("%d",&value);
	ptr = head;
	while(ptr->next!=head)
	{
		if(ptr->data==value)
		{
			printf("Value is found\n");
			j=1;
			break;
		}
		ptr=ptr->next;
	}
	if(ptr->data==value)
	{
		printf("Value is found\n");
		j=1;
	}
	if(j==0)
		printf("Value is not found\n");
}

void main()
{
	int choice;
	clrscr();
	printf("-----CIRCULAR SINGLE LINKED LIST-----\n\n");
	while(1)
	{
		printf("1. Insertion at beginning\n");
		printf("2. Insertion at last\n");
		printf("3. Insert at specific location\n");
		printf("4. Delete from beginning\n");
		printf("5. Delete from last\n");
		printf("6. Delete from specific location\n");
		printf("7. Display Linked List\n");
		printf("8. Search\n");
		printf("9. Quit\n\n");
		printf("Enter your choice\n");
		scanf("%d",&choice);
		printf("\n");

		switch(choice)
		{
			case 1: InsertionBeginning();
				break;
			case 2: InsertionLast();
				break;
			case 3: InsertSpecificLocation();
				break;
			case 4: DeleteBeginning();
				break;
			case 5: DeleteLast();
				break;
			case 6: DeleteSpecificLocation();
				break;
			case 7: Display();
				break;
			case 8: Search();
				break;
			case 9: exit(1);
				break;
			default: printf("Invalid Input\n");
		}
	}
}