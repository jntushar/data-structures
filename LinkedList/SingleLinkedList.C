#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

struct node
{
	int data;
	struct node* next;
};

struct node* head = NULL;

struct node* new_node(int n)
{
	struct node* temp;
	temp=(struct node*)malloc(sizeof(struct node));
	temp->data = n;
	temp->next=NULL;
	return temp;
}

void insert_beginning()
{
	int n;
	struct node* newNode;
	printf("Enter Integer value:\n");
	scanf("%d",&n);
	newNode = new_node(n);
	if(head==NULL)
		head=newNode;
	else
	{
		newNode->next=head;
		head=newNode;
	}
}

void insert_last()
{
	int n;
	struct node* newNode, *ptr;
	printf("Enter Integer Value:\n");
	scanf("%d",&n);
	newNode=new_node(n);
	if(head==NULL)
		head=newNode;
	else
		ptr=head;
		while(ptr->next!=NULL)
		{
			ptr=ptr->next;
		}
		ptr->next=newNode;
}

void insert_specific_location()
{
	int n,nodeNumber,count=1;
	struct node* newNode,*ptr;
	printf("Enter Node Number:\n");
	scanf("%d",&nodeNumber);
	printf("Enter Integer Value:\n");
	scanf("%d",&n);
	newNode=new_node(n);
	ptr=head;
	while(ptr!=NULL)
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

void delete_beginning()
{
	struct node* del;
	if(head==NULL)
		printf("Linked List is Empty");
	else
		del = head;
		head = head->next;
		del->next=NULL;
		free(del);
}

void delete_last()
{
	struct node* ptr,*prev;
	if(head==NULL)
		printf("Linked List Is Empty\n\n");
	else
		ptr=head;
		while(ptr->next!=NULL)
		{
			prev=ptr;
			ptr=ptr->next;
		}
		prev->next=NULL;
		free(ptr);
}

void delete_specific_location()
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
			free(ptr);
		}
		count++;
		prev=ptr;
		ptr=ptr->next;
	}
}

void display()
{
	struct node* ptr;
	ptr = head;
	if(ptr == NULL)
		printf("Linked List Is Empty\n\n");
	else
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
	printf("Enter Value to be searched:\n");
	scanf("%d",&value);
	ptr = head;
	while(ptr!=NULL)
	{
		if(ptr->data==value)
		{
			printf("Value is found\n");
			j=1;
			break;
		}
		ptr=ptr->next;
	}
	if(j==0)
		printf("Value is not found\n");
}

void insert_after_value()
{
	int value,n,j=0;
	struct node* ptr,*newNode;
	printf("Enter value after which you want to enter data:\n");
	scanf("%d",&value);
	printf("Enter Integer value:\n");
	scanf("%d",&n);
	ptr=head;
	newNode=new_node(n);
	if(head==NULL)
		head=newNode;
	else
	{
		while(ptr!=NULL)
		{
			if(ptr->data==value)
			{
				newNode->next=ptr->next;
				ptr->next=newNode;
				j=1;
			}
			ptr=ptr->next;
		}
	}
	if(j==0)
		printf("Value not found\n");
}

void delete_by_value()
{
	int value,j=0;
	struct node* ptr,*prev;
	printf("Enter value you want to delete:\n");
	scanf("%d",&value);
	ptr=head;
	if(head==NULL)
		printf("List is empty\n");
	else
	{
		while(ptr!=NULL)
		{
			if(ptr->data==value)
			{
				prev->next=ptr->next;
				ptr->next=NULL;
				free(ptr);
				j=1;
			}
			prev=ptr;
			ptr=ptr->next;
		}
	}
	if(j==0)
		printf("Value not found\n");
}

void reverse()
{
	struct node* current, *prev, *next;
	current = head;
	prev = NULL;
	while(current != NULL)
	{
		next = current->next;
		current->next = prev;
		prev = current;
		current = next;
	}
	head = prev;
}

void main()
{
	int choice;
	clrscr();
	while(1)
	{
		printf("-----Operations on Single Linked List-----\n\n");
		printf("1. Insert at Beginning\n");
		printf("2. Insert at Last\n");
		printf("3. Insert at Specific Location\n");
		printf("4. Delete from Beginning\n");
		printf("5. Delete from Last\n");
		printf("6. Delete from Specific Location\n");
		printf("7. Display Linked List\n");
		printf("8. Insert after value\n");
		printf("9. Delete by value\n");
		printf("10. Search Element\n");
		printf("11. Reverse a linked list\n");
		printf("12. Quit\n\n");
		printf("Enter Your Choice\n");
		scanf("%d",&choice);
		printf("\n");

		switch(choice)
		{
			case 1: insert_beginning();
				break;
			case 2: insert_last();
				break;
			case 3: insert_specific_location();
				break;
			case 4: delete_beginning();
				break;
			case 5: delete_last();
				break;
			case 6: delete_specific_location();
				break;
			case 7: display();
				break;
			case 8: insert_after_value();
				break;
			case 9: delete_by_value();
				break;
			case 10: search();
				break;
			case 11: reverse();
				break;
			case 12: exit(1);
				break;
			default: printf("OOPS!!!Invalid Input\n\n");
		}
	}
	getch();
}