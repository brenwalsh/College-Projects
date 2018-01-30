import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Garage {

	private ArrayList<Users> staffList;
	private ArrayList<Reservations> reserveList;
	private ArrayList<Resources> resourceList;

	public Garage ()
	{
		staffList = new ArrayList<Users>();
		reserveList = new ArrayList<Reservations>();
		resourceList = new ArrayList<Resources>();
	}

	public static void  main(String[] args)
	{ 
		Garage app = new Garage();
		
		app.run();
	} 

	public void  run()
	{
		int choice;
		do
		{
			choice = mainMenu();


			switch(choice)
			{
			case 1: addReserve();
			break;

			case 2: listReserve();
			break;

			case 3: editReserve();
			break;

			case 4: deleteReserve();
			break;

			case 5: addResource();
			break;

			case 6: listResource();
			break;

			case 7: editResource();
			break;

			case 8: deleteResource();
			break;

			case 9: addUser();
			break;

			case 10: listUser();
			break;

			case 11: editUser();
			break;

			case 12: deleteUser();
			break;

			case 13: try {

				loadGarage();

			}

			catch(Exception e){

				System.out.println("Error reading from file: " + e);

			}

			break;

			case 14: try{

				saveGarage();

			}

			catch(Exception e){

				System.out.println("Error writing to file: " + e);


			}
			}

		}while (choice !=0);

		System.out.println("Thank you for using the Garage");

	}

	private int mainMenu()

	{      
		
		System.out.println("");
		System.out.println("---Reservations--");
		System.out.println("1) Add a Reservation");
		System.out.println("2) List all Reservations");
		System.out.println("3) Edit a Reservation");
		System.out.println("4) Delete a Reservation");
		System.out.println("");
		System.out.println("---Resources---");
		System.out.println("5) Add a Resource");
		System.out.println("6) List All Resources");
		System.out.println("7) Edit a Resource");
		System.out.println("8) Delete a Resource");
		System.out.println("");
		System.out.println("---Users---");
		System.out.println("9) Add a New User");
		System.out.println("10) List All Users");
		System.out.println("11) Edit a User");
		System.out.println("12) Delete a User");
		System.out.println(" ");
		System.out.println("13) Load a Garage");
		System.out.println("14) Save the Garage");
		System.out.println("0) Exit");

		System.out.print("Select an option >");

		int option = EasyScanner.nextInt();

		if(option < 0 || option > 14)
		{
			System.out.println("You have selected an invalid option");
			System.out.print("Select another Option >");
			option = EasyScanner.nextInt();
		}

		else
		{
			System.out.println("You have selected: " +option);			
		}
		
		return option;
	}

	public void addReserve()
	{

		String reserveId, userId, resourceId, date;
		int duration;
		
		System.out.print("Enter Reservation Id > ");
		reserveId =EasyScanner.nextString();
		int reserveIndex = Integer.parseInt(reserveId);
		if(reserveIndex>reserveList.size())
		{
			System.out.print("Please Enter a Valid Number");
			reserveId =EasyScanner.nextString();
		}
		else
		{
			
		}

		System.out.print("Enter User Id > ");
		userId =EasyScanner.nextString();
		int userIndex = Integer.parseInt(userId);
		
		if(userIndex>staffList.size()||userIndex<0)
		{
			System.out.println("Please Enter a Valid User Id");
			userId =EasyScanner.nextString();
				
				
			}
			else
			{
				Users tempUser = staffList.get((userIndex-1));
				System.out.println("You have selected : " +tempUser.getfName() +" " +tempUser.getlName());
				
				
			}
			
				
		System.out.print("Enter Resource Id > ");
		resourceId =EasyScanner.nextString();
		int resourceIndex = Integer.parseInt(resourceId);
		

			
			if(resourceIndex>resourceList.size()||resourceIndex<0)
			{
				System.out.println("Please Enter a Valid Resource Id");
				resourceIndex =EasyScanner.nextInt();
			}
			else
			{
				Resources tempResource = resourceList.get(resourceIndex);
				System.out.println("You have selected : " +tempResource.getName());
				
			}
			
		System.out.println("Date of Reservation: " +getDateStamp());	   
		date = getDateStamp();

		System.out.print("Enter Duration (in hours) > ");
		duration =EasyScanner.nextInt();
		
			Reservations reserve = new Reservations(reserveId, userId, resourceId, date, duration);
			reserveList.add(reserve);
			Resources bookEdit = resourceList.get(resourceIndex);
			bookEdit.setBooked(true);
		
	}

	public void listReserve()
	{
		for(int index = 0; index<reserveList.size(); index++) {
			System.out.println("");
			System.out.println("Reservation "+ (index) +": " +reserveList.get(index));
		}
	}

	public void editReserve()
	{
		String newStringValue;
		int newIntValue, editChoice;



		System.out.println("Enter Reservation Index Number: ");
		int editIndex = EasyScanner.nextInt();

		if(editIndex>reserveList.size()||editIndex<0)
		{
			System.out.println("Enter another number: ");
			System.out.println("Reservation Index "+ (editIndex) +": " +reserveList.get(editIndex));
			
		}

		else
		{
			System.out.println("Reservation Index "+ (editIndex) +": " +reserveList.get(editIndex));
		}

		Reservations reserve = reserveList.get(editIndex);

		System.out.println("Enter the record you want to edit: ");

		System.out.println("1) Reservation Id");
		System.out.println("2) User Id");
		System.out.println("3) ResourceId");
		System.out.println("4) Date");
		System.out.println("5) Duration");

		editChoice = EasyScanner.nextInt();

		do{
			switch(editChoice)
			{
			case 1:

				System.out.println("Current Reservation Id: "+ reserve.getReserveId());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				reserve.setReserveId(newStringValue);

				System.out.print("New value: "+reserve.getReserveId());

				break;

			case 2: 

				System.out.println("Current User Id: "+ reserve.getUserId());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				reserve.setUserId(newStringValue);

				System.out.print("New value: "+reserve.getUserId());

				break;

			case 3:

				System.out.println("Current Resource Id: "+ reserve.getResourceId());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				reserve.setResourceId(newStringValue);

				System.out.print("New value: "+reserve.getResourceId());

				break;

			case 4: 

				System.out.println("Current Date: "+ reserve.getDate());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				reserve.setDate(newStringValue);

				System.out.print("New value: "+reserve.getDate());

				break;

			case 5: 

				System.out.println("Current Duration: "+ reserve.getDuration());

				System.out.print("Enter new value: ");
				newIntValue = EasyScanner.nextInt();
				reserve.setDuration(newIntValue);

				System.out.print("New value: "+reserve.getDuration());

				break;

			}

		}while(editChoice!=0);

	}
	
	public void deleteReserve()
	{
		int reserveIndex;

		System.out.print("Enter the index of the reservation you wish to delete > ");

		reserveIndex=EasyScanner.nextInt();

		if(reserveIndex>reserveList.size() || reserveIndex<0)
		{
			System.out.print("Enter a Valid Index Number >");
			reserveIndex=EasyScanner.nextInt();
		}
		else
		{
		reserveList.remove(reserveIndex);	
		}
	}

	public void addResource()
	{

		String resourceId, name;
		
		System.out.print("Enter Resource Id > ");
		resourceId =EasyScanner.nextString();

		System.out.print("Enter Resource Name > ");
		name =EasyScanner.nextString();

		Resources resource = new Resources(resourceId, name);
		resourceList.add(resource);
	}
	
	public void listResource()
	{
		for(int index =0; index<resourceList.size(); index++) {
			System.out.println("");
			System.out.println("Resource "+ (index) +": " +resourceList.get(index));
		}
	}

	public void editResource()
	{
		String newStringValue;
		int editChoice;



		System.out.println("Enter Resource Index Number: ");
		int editIndex = EasyScanner.nextInt();

		if(editIndex>resourceList.size()||editIndex<0)
		{
			System.out.println("Resource Index "+ (editIndex) +": " +resourceList.get(editIndex));
		}

		else
		{
			System.out.println("Enter another number: ");
			System.out.println("Resource Index "+ (editIndex) +": " +resourceList.get(editIndex));
		}

		Resources resource = resourceList.get(editIndex);

		System.out.println("Enter the record you want to edit: ");

		System.out.println("1) Resource Id");
		System.out.println("2) Resource Name");
		System.out.println("3) Booked");

		editChoice = EasyScanner.nextInt();

		do{
			switch(editChoice)
			{
			case 1:

				System.out.println("Current Resource Id: "+ resource.getResourceId());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				resource.setResourceId(newStringValue);

				System.out.println("New value: "+resource.getResourceId());

				break;

			case 2: 

				System.out.println("Current Resource Name: "+ resource.getName());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				resource.setName(newStringValue);

				System.out.println("New value: "+resource.getName());

				break;

			case 3: 

				System.out.println("Current Booking Status: "+ resource.isBooked());

				System.out.print("Enter new value: (y/n) ");
				newStringValue = EasyScanner.nextString();
				if(newStringValue == "y")
				{
				resource.setBooked(true);

				System.out.print("New value: "+resource.isBooked());
				}
				else if(newStringValue == "n")
				{
					resource.setBooked(false);

					System.out.print("New value: "+resource.isBooked());
					
				}
				else
				{
					System.out.println("Invalid answer, Please Try Again");
					System.out.print("Enter new value: (y/n) ");
					newStringValue = EasyScanner.nextString();
				}
								
				break;

			}

		}while(editChoice!=0);

	}
	
	public void deleteResource()
	{
		int resourceIndex;

		System.out.print("Enter the index of the resource you wish to delete > ");

		resourceIndex=EasyScanner.nextInt();
		
		if(resourceIndex>resourceList.size() || resourceIndex<0)
		{
			System.out.print("Enter a Valid Index Number >");
			resourceIndex=EasyScanner.nextInt();
		}
		else
		{
			resourceList.remove(resourceIndex);
		}
	}
	
	public void addUser()
	{
		String id, fname, lName, role, phoneNum, userType;
		

		System.out.print("Enter User Id > ");
		id =EasyScanner.nextString();

		System.out.print("Enter First Name > ");
		fname =EasyScanner.nextString();
		
		System.out.print("Enter Last Name > ");
		lName =EasyScanner.nextString();

		System.out.print("Enter User Role > ");
		role =EasyScanner.nextString();

		System.out.print("Enter Phone Number > ");
		phoneNum =EasyScanner.nextString();

		System.out.print("Enter User Type > ");
		userType =EasyScanner.nextString();
		
		Users user = new Users(id, fname, lName, role, phoneNum, userType);
		staffList.add(user);

	}
	
	public void listUser()

	{
		for(int index =0; index<staffList.size(); index++) {
			System.out.println("");
			System.out.println("User "+ (index) +": " +staffList.get(index));
		}
	}
	
	public void editUser()
	{
		String newStringValue;
		int editChoice;



		System.out.println("Enter User Index Number: ");
		int editIndex = EasyScanner.nextInt();

		if(editIndex>staffList.size()||editIndex<0)
		{
			System.out.println("User Index "+ (editIndex) +": " +staffList.get(editIndex));
		}

		else
		{
			System.out.println("Enter another number: ");
			System.out.println("User Index "+ (editIndex) +": " +staffList.get(editIndex));
		}

		Users user = staffList.get(editIndex);

		System.out.println("Enter the record you want to edit: ");

		System.out.println("1) User Id");
		System.out.println("2) First Name");
		System.out.println("3) Last Name");
		System.out.println("4) Role");
		System.out.println("5) Phone Number");
		System.out.println("6) User Type");

		editChoice = EasyScanner.nextInt();

		do{
			switch(editChoice)
			{
			case 1:

				System.out.println("Current User Id: "+ user.getId());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				user.setId(newStringValue);

				System.out.print("New value: "+user.getId());

				break;

			case 2: 

				System.out.println("Current First Name: "+ user.getfName());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				user.setfName(newStringValue);

				System.out.print("New value: "+user.getfName());

				break;

			case 3: 

				System.out.println("Current Last Name: "+ user.getlName());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				user.setlName(newStringValue);

				System.out.print("New value: "+user.getlName());
								
				
				break;
				
			case 4: 

				System.out.println("Current Role: "+ user.getRole());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				user.setRole(newStringValue);

				System.out.print("New value: "+user.getRole());
								
				
				break;
				
			case 5: 

				System.out.println("Current Phone Number: "+ user.getPhoneNum());

				System.out.print("Enter new value: ");
				newStringValue = EasyScanner.nextString();
				user.setPhoneNum(newStringValue);

				System.out.print("New value: "+user.getPhoneNum());
								
				
				break;

			case 6: 

				System.out.println("Current User Type: "+ user.getUserType());

				System.out.print("Enter new value: (admin/user) ");
				newStringValue = EasyScanner.nextString();
				
				if(newStringValue == "admin")
				{
				user.setUserType("admin");

				System.out.print("New value: "+user.getUserType());
				}
				else if(newStringValue == "user")
				{
					user.setUserType("user");

					System.out.print("New value: "+user.getUserType());
					
				}
				else
				{
					System.out.println("Invalid answer, Please Try Again");
					System.out.print("Enter new value: (admin/user) ");
					newStringValue = EasyScanner.nextString();
				}
																
				break;

			}

		}while(editChoice!=0);

	}
	
	public void deleteUser()
	{
		int userIndex;

		System.out.print("Enter the index of the User you wish to delete > ");

		userIndex=EasyScanner.nextInt();

		staffList.remove(userIndex);
	}
	
	public void saveGarage() throws Exception

	    {

	    XStream xstream = new XStream(new DomDriver());

	    ObjectOutputStream out = xstream.createObjectOutputStream

	    (new FileWriter("products.xml"));

	    out.writeObject(reserveList);

	    out.writeObject(resourceList);
	    
	    out.writeObject(staffList);

	    out.close();

	    }

	public void loadGarage() throws Exception

	    {

	    XStream xstream = new XStream(new DomDriver());

	    ObjectInputStream is = xstream.createObjectInputStream

	    (new FileReader("products.xml"));

	    reserveList = (ArrayList<Reservations>) is.readObject();

	    resourceList = (ArrayList<Resources>) is.readObject();

	    staffList = (ArrayList<Users>) is.readObject();

	    is.close();

	    }
	 
	public static String getDateStamp() {
		    SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy ");
		    Date now = new Date();
		    String strDate = sdfDate.format(now);
		    return strDate;
		}
	 
	
}

   