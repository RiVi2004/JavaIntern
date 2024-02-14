import java.util.Scanner;
class StudentGradeCalculation
{
	public static void main(String args[])
	{
		int s_regno;
		int marks[] = new int[5];
		int sum=0;
		int avg;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter reg no:");
		s_regno=input.nextInt();
		System.out.println("Reg.No="+s_regno);
		System.out.println("Enter Marks:");
		for(int i=0;i<5;i++)
		{
			marks[i]=input.nextInt();
		}
		for(int i=0;i<5;i++)
		{
			sum=sum+marks[i];
		}
		System.out.println("Mark="+sum);
		avg=sum/5;
		if(avg<=100&&avg>=95)
		{
			System.out.println("O grade");
		}
		else if(avg<=94&&avg>=90)
		{
			System.out.println("A+ grade");
		}		
		else if(avg<90&&avg>=85)
		{
			System.out.println("A grade");
		}
		else if(avg<85&&avg>=80)
		{
			System.out.println("B grade");
		}
		else if(avg<85&&avg>=70)
		{
			System.out.println("C grade");
		}
		else if(avg<70&&avg>=50)
		{
			System.out.println("D grade");
		}
		else
		{
			System.out.println("Fail");
		}
	}
}

