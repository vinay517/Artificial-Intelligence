public class BlockProblem
{
public char istate[][]=new char[][]{{'o','o','o','o'},{'o','o','o','o'},{'o','o','o','o'},{'o','o','o','o'},{'o','o','o','o'},{'o','o','o','o'},{'o','o','o','o'},{'c','d','o','o'},{'i','e','f','h'},{'j','a','b','g'}};
public char fstate[][]=new char[][]{{'o','o','o','o'},{'o','o','o','o'},{'o','o','o','o'},{'o','o','o','o'},{'o','o','o','o'},{'o','o','o','o'},{'o','i','o','o'},{'a','j','o','o'},{'c','h','b','o'},{'e','g','d','f'}};
public int l0c=0,l1c=0,l2c=0,l3c=0,k=0,match=1,x=0,y=0;
public String[] array = { "L1","L2","L3","L4"};
public int state=0;
public void initialData( )
   {
    char assign0,assign1,assign2,assign3;
    System.out.println("World of Blocks Problem\n");
    System.out.println("Given  Initial state");
    for (int i=0;i<10;i++)
    {
    for(int j=0;j<4;j++)
    {
    if(istate[i][j]=='o')
    { istate[i][j]='\u0020';
    System.out.print(istate[i][j]+"\t");}
    else {
     System.out.print("["+istate[i][j]+"]\t"); }
     if(istate[i][j]=='\u0020') {istate[i][j]='o';}
     }
    System.out.print("\n");
    }
    System.out.println("-----------------------------");
    System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
    System.out.println("\n"+"\n");
    System.out.println("Given Final state");
    for (int i=0;i<10;i++)
    {
    	for(int j=0;j<4;j++)
    	{
    		if(fstate[i][j]=='o')
    		{  fstate[i][j]='\u0020';
    		System.out.print(fstate[i][j]+"\t");}
    		else
    		{
    			System.out.print("["+fstate[i][j]+"]\t");}
    		if(fstate[i][j]=='\u0020') {fstate[i][j]='o';}
    	}
    	System.out.print("\n");
    }
    System.out.println("-----------------------------");
    System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
    System.out.println("\n"+"\n");
    for(int i=0;i<10;i++)
    {
    	assign0=istate[i][0];
   if(assign0!='o')   
   {
	   l0c=l0c+1;  
   } 
    }
    for(int i=0;i<10;i++)
    {
    	assign1=istate[i][1];
    	if(assign1!='o')   
    	{
    		l1c=l1c+1;  
    	} 
    }
    for(int i=0;i<10;i++)
    {
    	assign2=istate[i][2];
    	if(assign2!='o')   
    	{
    		l2c=l2c+1;  
    	} 
    }
    for(int i=0;i<10;i++)
    {
    	assign3=istate[i][3];
    	if(assign3!='o')   
    	{
    		l3c=l3c+1;  
    	} 
    }
  //  System.out.println("counts l0c="+l0c+" l1c="+l1c+" l2c="+l2c+" l3c="+l3c);
 }
  public void startegy0( )
 {
	  //System.out.println("\n Applying my strategy at L1 location");
	  char temp;
	  int count=0;
	  while(match==1)
	  {
		  for(int i=9,j=0;i>=0;i--)
		  {
			  if(istate[i][j]==fstate[i][j])
			  { 
				  count++;
			  }
			  else
			  {
				  int x=9-count;
				  for(int l=0;l<=x;l++)
				  {
					  if(istate[l][j]=='o')
					  {
					  }
					  else
					  {
						  temp=istate[l][j];

						  int p=j+1; //"p" indicates column no.
						  int q=9-l1c; //"q,q1" indicates row no.
						  istate[q][p]=temp;
						  istate[l][j]='o';
						  l1c++;
						  l0c--;
						  state=state+1;
						  System.out.println("State="+state);
						  System.out.println("\n Moving Block ["+temp+"] from location(L"+(j+1)+") to location(L"+(p+1)+")");
						  for (int a=0;a<10;a++)
						  {
							  for(int b=0;b<4;b++)
							  {
								  if(istate[a][b]=='o')
								  {  istate[a][b]='\u0020';
								  System.out.print(istate[a][b]+"\t");}
								  else
								  {
									  System.out.print("["+istate[a][b]+"]\t");}
								  if(istate[a][b]=='\u0020') {istate[a][b]='o';}
							  }
							  System.out.print("\n");
						  }
						  System.out.println("-----------------------------");
						  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
						  System.out.println("\n"+"\n");
					  }
				  }
			  }
		  }
		  for(int i=9,j=0;i>=0;i--)
		  {
			  char temp2;
			  if(istate[i][j]==fstate[i][j])
			  { 
			  }
			  else
			  {  
				  temp2=fstate[i][j];
				  for(int l=0;l<10;l++)
				  {
					  for(int n=1;n<4;n++)
					  {
						  if(temp2==istate[l][n])
						  {
							  x=l;
							  y=n;
						  }
						  else
						  { 
 
						  }
					  }
				  }
				  int l=0,z=0;
				  char temp20;
				  for(l=0,z=y;l<x;l++)
				  {   
					  if(istate[l][z]=='o')
					  {
					  }
					  else
					  { 
						  int p=0,q1=0;
						  temp20=istate[l][z];
						  if(z==3)
						  {
							  p=2;
							  q1=9-l2c;
							  istate[q1][p]=temp20;
							  istate[l][z]='o';
							  l2c++;
							  l3c--;
							  state=state+1;
							  System.out.println("State="+state);
							  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")");
							  for (int a=0;a<10;a++)
							  {
								  for(int b=0;b<4;b++)
								  {
									  if(istate[a][b]=='o')
									  {
										  istate[a][b]='\u0020';
										  System.out.print(istate[a][b]+"\t");
									  }
									  else {
										  System.out.print("["+istate[a][b]+"]\t");}
									  if(istate[a][b]=='\u0020') {istate[a][b]='o';} 
								  }
								  System.out.print("\n");
							  }
							  System.out.println("-----------------------------");
							  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
							  System.out.println("\n"+"\n");
						  }
						  else if(z==2)
						  {
							  p=3;
							  q1=9-l3c;
							  istate[q1][p]=temp20;
							  istate[l][z]='o';
							  l3c++;
							  l2c--;
							  state=state+1;
							  System.out.println("State="+state);
							  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")");
							  for (int a=0;a<10;a++)
							  {
								  for(int b=0;b<4;b++)
								  {
									  if(istate[a][b]=='o')
									  {istate[a][b]='\u0020';
									  System.out.print(istate[a][b]+"\t");}
									  else {
										  System.out.print("["+istate[a][b]+"]\t");
									  }
									  if(istate[a][b]=='\u0020') {istate[a][b]='o';} 
								  }
								  System.out.print("\n");
							  }
							  System.out.println("-----------------------------");
							  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
							  System.out.println("\n"+"\n");
						  }
						  else if(z==1)
						  {  
							  p=2;
							  q1=9-l2c;
							  istate[q1][p]=temp20;
							  istate[l][z]='o';
							  l2c++;
							  l1c--;
							  state=state+1;
							  System.out.println("State="+state);
							  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")"); 
							  for (int a=0;a<10;a++)
							  {
								  for(int b=0;b<4;b++)
								  {
									  if(istate[a][b]=='o')
									  {  istate[a][b]='\u0020';
									  System.out.print(istate[a][b]+"\t");}
									  else {
										  System.out.print("["+istate[a][b]+"]\t");}
									  if(istate[a][b]=='\u0020') {istate[a][b]='o';} 
								  }
								  System.out.print("\n");
							  }
							  System.out.println("-----------------------------");
							  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
							  System.out.println("\n"+"\n");
						  }
					  }
				  }
				  istate[i][j]=istate[x][y];
				  l0c++;
				  istate[x][y]='o';
				  if(y==3) { l3c--;}
				  else if(y==2) {l2c--;}
				  else if(y==1) {l1c--;} 
				  if(istate[i][j]=='o')
				  { 
				  }
				  else {
					  state=state+1;
					  System.out.println("State="+state);
					  System.out.println("\n Moving Block ["+istate[i][j]+"] from location(L"+(y+1)+") to location(L"+(j+1)+")");
					  for (int a=0;a<10;a++)
					  {
						  for(int b=0;b<4;b++)
						  {
							  if(istate[a][b]=='o')
							  { istate[a][b]='\u0020';
							  System.out.print(istate[a][b]+"\t");}
							  else {
								  System.out.print("["+istate[a][b]+"]\t");
							  }
							  if(istate[a][b]=='\u0020') {istate[a][b]='o';} 
						  }
						  System.out.print("\n");
					  } 
					  System.out.println("-----------------------------");
					  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
					  System.out.println("\n"+"\n");
				  }
			  }
		  }
		  match=2; // while loop ends here
	  } 
 }
  public void startegy1( )
  {
  //System.out.println("\n Applying my strategy at L2 location");
  char temp40;
  int count=0;
  match=1;
  while(match==1)
  {
	  for(int i=9,j=1;i>=0;i--)
	  {
		  if(istate[i][j]==fstate[i][j])
		  { 
  
			  count++;
		  }
		  else
		  {
			  int x2=9-count;
			  for(int l=0;l<=x2;l++)
			  {
				  if(istate[l][j]=='o')
				  {
				  }
				  else
				  {
					  temp40=istate[l][j];
					  int p=j+1; //"p" indicates column no.
					  int q=9-l2c; //"q,q1" indicates row no.
					  istate[q][p]=temp40;
					  istate[l][j]='o';
					  l2c++;
					  l1c--;
					  state=state+1;
					  System.out.println("State="+state);
					  System.out.println("\n Moving Block ["+temp40+"] from location(L"+(j+1)+") to location(L"+(p+1)+")");
					  for (int a=0;a<10;a++)
					  {
						 for(int b=0;b<4;b++)
						 {
							 if(istate[a][b]=='o')
							 {  istate[a][b]='\u0020';
							 System.out.print(istate[a][b]+"\t");}
							 else
							 {
								 System.out.print("["+istate[a][b]+"]\t");}
							 if(istate[a][b]=='\u0020') {istate[a][b]='o';} 
						 }
						 System.out.print("\n");
					  }
					  System.out.println("-----------------------------");
					  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
					  System.out.println("\n"+"\n");
				  }
			  }
		  }
	  }
	  for(int i=9,j=1;i>=0;i--)
	  {
		  char temp2;
		  if(istate[i][j]==fstate[i][j])
		  { 
		  }
		  else
		  {  
			  temp2=fstate[i][j];
			  for(int l=0;l<10;l++)
			  {
				  for(int n=1;n<4;n++)
				  {
					  if(temp2==istate[l][n])
					  {
						  x=l;
						  y=n;
					  }
					  else
					  { 
   
					  }
				  }
	 }
			  int l=0,z=0;
			  char temp20;
			  for(l=0,z=y;l<x;l++)
			  {   
				  if(istate[l][z]=='o')
				  {
				  }
				  else
				  { 
					  int p=0,q1=0;
					  temp20=istate[l][z];
					  if(z==3)
					  {
						  p=2;
						  q1=9-l2c;
						  istate[q1][p]=temp20;
						  istate[l][z]='o';
						  l2c++;
						  l3c--;
						  state=state+1;
						  System.out.println("State="+state);
						  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")");
						  for (int a=0;a<10;a++)
						  {
							  for(int b=0;b<4;b++)
							  {
								  if(istate[a][b]=='o')
								  {
									  istate[a][b]='\u0020';
									  System.out.print(istate[a][b]+"\t");}
								  else {
									  System.out.print("["+istate[a][b]+"]\t");
								  }
								  if(istate[a][b]=='\u0020') {istate[a][b]='o';}
							  }
							  System.out.print("\n");
						  }
						  System.out.println("-----------------------------");
						  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
						  System.out.println("\n"+"\n");
					  }
					  else if(z==2)
					  {
						  p=3;
						  q1=9-l3c;
						  istate[q1][p]=temp20;
						  istate[l][z]='o';
						  l3c++;
						  l2c--;
						  state=state+1;
						  System.out.println("State="+state);
						  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")");
						  for (int a=0;a<10;a++)
						  {
							  for(int b=0;b<4;b++)
							  {
								  if(istate[a][b]=='o')
								  {
									  istate[a][b]='\u0020';
									  System.out.print(istate[a][b]+"\t");
								  }
								  else {
									  System.out.print("["+istate[a][b]+"]\t");
								  }
								  if(istate[a][b]=='\u0020') {istate[a][b]='o';} 
							  }
							  System.out.print("\n");
						  }
						  System.out.println("-----------------------------");
						  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
						  System.out.println("\n"+"\n");
					  }
					  else if(z==0)
					  {  
						  p=2;
						  q1=9-l2c;
						  istate[q1][p]=temp20;
						  istate[l][z]='o';
						  l2c++;
						  l0c--;
						  state=state+1;
						  System.out.println("State="+state);
						  System.out.println("Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")"); 
						  for (int a=0;a<10;a++)
						  {
							  for(int b=0;b<4;b++)
							  {
								  if(istate[a][b]=='o')
								  {
									  istate[a][b]='\u0020';
									  System.out.print(istate[a][b]+"\t");}
								  else {
									  System.out.print("["+istate[a][b]+"]\t");
								  }
								  if(istate[a][b]=='\u0020') {istate[a][b]='o';} 
							  }
  System.out.print("\n");
  }
  System.out.println("-----------------------------");
  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
  System.out.println("\n"+"\n");
  }
  }
    }
  istate[i][j]=istate[x][y];
  l1c++;
  istate[x][y]='o';
  if(y==3) { l3c--;}
  else if(y==2) {l2c--;}
  else if(y==0) {l0c--;} 
  if(istate[i][j]=='o')
{ 
 
}
else {
	state=state+1;
	System.out.println("State="+state);
	System.out.println("\n Moving Block ["+istate[i][j]+"] from location(L"+(y+1)+") to location(L"+(j+1)+")");
	for (int a=0;a<10;a++)
	{
		for(int b=0;b<4;b++)
		{
			if(istate[a][b]=='o')
			{
				istate[a][b]='\u0020';
				System.out.print(istate[a][b]+"\t");
			}
			else {
				System.out.print("["+istate[a][b]+"]\t");
			}
			if(istate[a][b]=='\u0020') {istate[a][b]='o';} 
		}
		System.out.print("\n");
	}
	System.out.println("-----------------------------");
	System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
	System.out.println("\n"+"\n");
	}
		  }
	  }
  match=2; // while loop ends here
  	}
  }
  public void startegy2( )
  {
  //System.out.println("\n Applying my strategy at L3 location");
  char temp;
  int count=0;
  match=1;
  while(match==1)
  {
  for(int i=9,j=2;i>=0;i--)
  {
  if(istate[i][j]==fstate[i][j])
  { 
  count++;
  }
  else
  {
  int x=9-count;
  for(int l=0;l<=x;l++)
  {
  if(istate[l][j]=='o')
  {
  }
  else
  {
  temp=istate[l][j];
  int p=j+1;
  int q=9-l3c;
  istate[q][p]=temp;
  istate[l][j]='o';
  l3c++;
  l2c--;
  state=state+1;
  System.out.println("State="+state);
  System.out.println("\n Moving Block ["+temp+"] from location(L"+(j+1)+") to location(L"+(p+1)+")");
  for (int a=0;a<10;a++)
  {
  for(int b=0;b<4;b++)
  {
  if(istate[a][b]=='o')
      { istate[a][b]='\u0020';
  System.out.print(istate[a][b]+"\t"); }
  else
  {System.out.print("["+istate[a][b]+"]\t");}
       if(istate[a][b]=='\u0020') {istate[a][b]='o';} 
  }
  System.out.print("\n");
  }
  System.out.println("-----------------------------");
  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
  System.out.println("\n"+"\n");
  }
  }
  }
  }
  for(int i=9,j=2;i>=0;i--)
  {
  if(istate[i][j]==fstate[i][j])
  { 
  }
  else
  {  
  char temp2;
  temp2=fstate[i][j];
  for(int l=0;l<10;l++)
  {
  for(int n=1;n<4;n++)
  {
  if(temp2==istate[l][n])
  {
  x=l;
  y=n;
  }
  else
  { 
   
  }
       }
  }
  int l=0,z=0;
  char temp20;
  for(l=0,z=y;l<x;l++)
  {   
  if(istate[l][z]=='o')
  {
  
  }
  else
  { 
  int p=0,q1=0;
  temp20=istate[l][z];
  if(z==3)
  {
  p=1;
  q1=9-l1c;
  istate[q1][p]=temp20;
  istate[l][z]='o';
  l1c++;
  l3c--;
  state=state+1;
  System.out.println("State="+state);
  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")");
  for (int a=0;a<10;a++)
  {
  for(int b=0;b<4;b++)
  {
  if(istate[a][b]=='o')
      { istate[a][b]='\u0020';
  System.out.print(istate[a][b]+"\t");}
  else {
       System.out.print("["+istate[a][b]+"]\t");}
       if(istate[a][b]=='\u0020') {istate[a][b]='o';}
  }
  System.out.print("\n");
  }
  System.out.println("-----------------------------");
System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
System.out.println("\n"+"\n");
  }
  else if(z==1)
  {
  p=3;
  q1=9-l3c;
  istate[q1][p]=temp20;
  istate[l][z]='o';
  l3c++;
  l1c--;
  state=state+1;
  System.out.println("State="+state);
  System.out.println("\n Moving Block ["+temp20+"] from Location(L"+(z+1)+") to location(L"+(p+1)+")");
  for (int a=0;a<10;a++)
  {
  for(int b=0;b<4;b++)
  {
  if(istate[a][b]=='o')
  {  istate[a][b]='\u0020';
  System.out.print(istate[a][b]+"\t");}
  else { System.out.print("["+istate[a][b]+"]\t");}
       if(istate[a][b]=='\u0020') {istate[a][b]='o';}
  }
  System.out.print("\n");
  }
  System.out.println("-----------------------------");
System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
System.out.println("\n"+"\n");
  }
  else if(z==0)
  {  
  p=1;
  q1=9-l1c;
  istate[q1][p]=temp20;
  istate[l][z]='o';
  l1c++;
  l0c--;
  state=state+1;
  System.out.println("State="+state);
  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")"); 
  for (int a=0;a<10;a++)
  {
  for(int b=0;b<4;b++)
  {
  if(istate[a][b]=='o')
      {istate[a][b]='\u0020';
  System.out.print(istate[a][b]+"\t");}
  else {
  System.out.print("["+istate[a][b]+"]\t");
  }
       if(istate[a][b]=='\u0020') {istate[a][b]='o';}
  }
  System.out.print("\n");
  }
  System.out.println("-----------------------------");
  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]); 
  System.out.println("\n"+"\n");
  }
  }
    }
  istate[i][j]=istate[x][y];
  l2c++;
  istate[x][y]='o';
  if(y==3) { l3c--;}
  else if(y==1) {l1c--;}
  else if(y==0) {l0c--;} 
  if(istate[i][j]=='o')
{ 
 
}
else {
	state=state+1;
	System.out.println("State="+state);
System.out.println("\n Moving Block ["+istate[i][j]+"] from location(L"+(y+1)+") to location(L"+(j+1)+")");
for (int a=0;a<10;a++)
{
for(int b=0;b<4;b++)
{
if(istate[a][b]=='o')
{  istate[a][b]='\u0020';
System.out.print(istate[a][b]+"\t");}
else {
System.out.print("["+istate[a][b]+"]\t");
}
     if(istate[a][b]=='\u0020') {istate[a][b]='o';}
}
System.out.print("\n");
}
System.out.println("-----------------------------");
System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]); 
System.out.println("\n"+"\n");
}
  }
  }
  match=2; // while loop ends here
  }
  }

 public void startegy3( )
  {
 // System.out.println("\n Applying my strategy at L4 location");
  char temp30;
  int count3=0;
  match=1;
  while(match==1)
  {
  for(int i=9,j=3;i>=0;i--)
  { 
  if(istate[i][j]==fstate[i][j])
  { 
  count3++;
  }
  else
  { 
  int x=9-count3;
  for(int m=0;m<=x;m++)
  {
  if(istate[m][j]=='o')
  {
  }
  else
  {
       temp30=istate[m][j];
  int p=j-1;
  int q=9-l2c;
  istate[q][p]=temp30;
  istate[m][j]='o';
  l2c++;
  l3c--;
  state=state+1;
  System.out.println("State="+state);
  System.out.println("\n Moving Block ["+temp30+"]from location(L"+(j+1)+") to location(L"+(p+1)+")");
  for (int a=0;a<10;a++)
  {
  for(int b=0;b<4;b++)
  {
  if(istate[a][b]=='o')
  {  istate[a][b]='\u0020';
  System.out.print(istate[a][b]+"\t");}
  else {
  System.out.print("["+istate[a][b]+"]\t");
  }
       if(istate[a][b]=='\u0020') {istate[a][b]='o';}
  }
  System.out.print("\n");
  }
  System.out.println("-----------------------------");
  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]); 
  System.out.println("\n"+"\n");
  }
  }
  }
  }
  for(int i=9,j=3;i>=0;i--)
  {
  char temp2;
  if(istate[i][j]==fstate[i][j])
  { 
  }
  else
  {  
  temp2=fstate[i][j];
  for(int l=0;l<10;l++)
  {
  for(int n=1;n<4;n++)
  {
  if(temp2==istate[l][n])
  {
  x=l;
  y=n;
  }
  else
  { 
   
  }
       }
  }
  int l=0,z=0;
  char temp20;
  for(l=0,z=y;l<x;l++)
  {   
  if(istate[l][z]=='o')
  {
  }
  else
  { 
  int p=0,q1=0;
  temp20=istate[l][z];
  if(z==2)
  {
  p=1;  
  q1=9-l1c;

  istate[q1][p]=temp20;
  istate[l][z]='o';
  l1c++;
  l2c--;
  int e=z;
  int o=p;
  state=state+1;
  System.out.println("State="+state);
  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(o+1)+")");
  for (int a=0;a<10;a++)
  {
  for(int b=0;b<4;b++)
  {
  if(istate[a][b]=='o')
  {  istate[a][b]='\u0020';
  System.out.print(istate[a][b]+"\t");}
  else {
       System.out.print("["+istate[a][b]+"]\t");}
       if(istate[a][b]=='\u0020') {istate[a][b]='o';}
  }
  System.out.print("\n");
  }
  System.out.println("-----------------------------");
  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]); 
  System.out.println("\n"+"\n");
  }
  else if(z==1)
  {
  p=2;
  q1=9-l2c;
  istate[q1][p]=temp20;
  istate[l][z]='o';
  l2c++;
  l1c--;
  state=state+1;
  System.out.println("State="+state);
  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")");
  for (int a=0;a<10;a++)
  {
  for(int b=0;b<4;b++)
  {
  if(istate[a][b]=='o')
      {
  istate[a][b]='\u0020';
  System.out.print(istate[a][b]+"\t");
      }
  else{
  System.out.print("["+istate[a][b]+"]\t");
  }
       if(istate[a][b]=='\u0020') {istate[a][b]='o';}
  }
  System.out.print("\n");
  }
  System.out.println("-----------------------------");
  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]);
  System.out.println("\n"+"\n");
  }
  else if(z==0)
  {  
  p=1;
  q1=9-l1c;
  istate[q1][p]=temp20;
  istate[l][z]='o';
  l1c++;
  l0c--;
  state=state+1;
  System.out.println("State="+state);
  System.out.println("\n Moving Block ["+temp20+"] from location(L"+(z+1)+") to location(L"+(p+1)+")"); 
  for (int a=0;a<10;a++)
  {
  for(int b=0;b<4;b++)
  {
  if(istate[a][b]=='o')
      {
  istate[a][b]='\u0020';
  System.out.print(istate[a][b]+"\t");
      }
  else {
       System.out.print("["+istate[a][b]+"]\t");}
       if(istate[a][b]=='\u0020') {istate[a][b]='o';}
  }
  System.out.print("\n");
  }
  System.out.println("-----------------------------");
  System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]); 
  System.out.println("\n"+"\n");
  }
  }
    }
  istate[i][j]=istate[x][y];
  l3c++;
  istate[x][y]='o';
  if(y==2) { l2c--;}
  else if(y==1) {l1c--;}
  else if(y==0) {l0c--;} 
  if(istate[i][j]=='o')
{ 
 
}
else {
	state=state+1;
	System.out.println("State="+state);
System.out.println("\n Moving Block ["+istate[i][j]+"] from location(L"+(y+1)+") to location(L"+(j+1)+")");
for (int a=0;a<10;a++)
{
for(int b=0;b<4;b++)
{
if(istate[a][b]=='o')
    {
istate[a][b]='\u0020';
System.out.print(istate[a][b]+"\t");
    }
else { System.out.print("["+istate[a][b]+"]\t");}
     if(istate[a][b]=='\u0020') {istate[a][b]='o';}
}
System.out.print("\n");
}
System.out.println("-----------------------------");
System.out.println(array[0]+"\t"+array[1]+"\t"+array[2]+"\t"+array[3]); 
System.out.println("\n"+"\n");
}
  }
  }
  match=2; // while loop ends here
  }
  }
 public static void main(String[] args) {
BlockProblem test=new BlockProblem();
 test.initialData();
 test.startegy0();
 test.startegy1();
 test.startegy2();
 test.startegy3();
 System.out.println(" At the end the blocks in the Initial State are matching with the blocks displaying in the Final state");
 // TODO Auto-generated method stub
 }

}


