import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		// TODO Auto-generated method stub

		System.out.println("welocme to student management app");
		
		while(true)
		{
			System.out.println("PRESS 1 TO ADD STUDENT");
			System.out.println("PRESS  2 TO DELETE STUDENT");
			System.out.println("PRESS 3 TO DISPLAY STUDENT");
			System.out.println("PRESS 4 TO EXIT APP");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1)
			{
				//add student;
				System.out.println("enter name : ");
				String name = br.readLine();
				
				System.out.println("enter user phone : ");
				String phone = br.readLine();
				
				System.out.println("enter user city : ");
				String city = br.readLine();
				
				Student st = new Student(name,phone,city);
				
				boolean ans = StudentDao.insertStudent(st);
				
				if(ans == true)
				{
					System.out.println("student added successfully");
				}
				else
				{
					System.out.println("something went wrong");
				}
				
			}
			else if(c == 2)
			{
				//delete student
				
				System.out.println("enter user id to delete");
				
				int id = Integer.parseInt(br.readLine());
				
				boolean ans = StudentDao.deleteStudent(id);
				
				if(ans == true)
				{
					System.out.println("Student deleted successfully");
				}
				else 
				{
					System.out.println("something went wrong");
				}
			}
			else if(c == 3)
			{
				//display student
				
				StudentDao.showAllStudent();
			
			}
			else if(c == 4)
			{
				//exit
				break;
			}
			else
			{
				
			}
		
		
		}
		System.out.println("THANK YOU FOR USING MY APPLICATION");
	}

}
