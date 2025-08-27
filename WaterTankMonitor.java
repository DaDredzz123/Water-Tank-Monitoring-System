import javax.swing.JOptionPane;

		
		abstract class waterTank {
		
		int currentLvel;
		int liters;
		int capacity;
		
		public waterTank( int capacity) {
			
			this.capacity = capacity;
			this.currentLvel = 0;
		}
		//abstract methods
		public abstract void fill(int liters);
		public abstract void useWater(int liters);
		public abstract String status();
		public abstract String getTankname();
		}
		//subclass HomeT
		class Hometank extends waterTank {

			public Hometank() {
				super(100);
				
			}


			@Override
			public void fill(int liters) {
				currentLvel += liters;
				if (currentLvel > capacity) currentLvel = capacity;
				
			}

			@Override
			public void useWater(int liters) {
				currentLvel -= liters;
				if (currentLvel < 0) currentLvel = 0;
			}

			@Override
			public String status() {
			if (currentLvel == 0) return "ay hala ubos na";
			else if (currentLvel == capacity) return "uy full pa!";
			else return "ginagamit pa";
				
			}
			
			@Override
			public String getTankname() {
			return "Home Tank";
		}
		}	
		
		class BuildTank extends waterTank {
			public BuildTank() {
				super(1000);
			}

			@Override
			public void fill(int liters) {
				currentLvel += liters;
				if (currentLvel > capacity) currentLvel = capacity;
				
			}

			@Override
			public void useWater(int liters) {
				currentLvel -= liters;
				if (currentLvel < 0) currentLvel = 0;
				
			}

			@Override
			public String status() {
				if (currentLvel == 0) return "ubos naman uy";
				else if (currentLvel == capacity) return "yeey full pa";
				else return "oops! ginagamit pa";
	
			}
			@Override
			public String getTankname() {
			return "Building Tank";
			
		}
		}
		public class WaterTankMonitor {
			public static void main(String[] args) {
		    waterTank[] tanks = { new Hometank(), new BuildTank() };
		    
		    JOptionPane.showMessageDialog(null, " Hello and welcome to the Water Tank Monitor System.");
		    JOptionPane.showMessageDialog(null, " Please choose a Tank to Monitor ");
		
		    while(true) {
		    	String[] Options = {" Home Tank " , " Building Tank "};
		    	int choice = JOptionPane.showOptionDialog(null, "Selection of Tanks. Please Choose" , " Tank Selections", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Options, Options[0]); 
		    	
		      
		    	if(choice == -1) break;
		    	
		    	waterTank selectedTank = tanks[choice];
		    	JOptionPane.showMessageDialog(null, "You selected: " + selectedTank.getTankname());
		    	String[] Action = {" Fill Tank ", " Use water ", "Exit"};
		    	int ChoiceAction = JOptionPane.showOptionDialog(null, "What would you like to do with the selected tank?" , "CHOICE OF ACTIONS", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, Action, Action[0]);
		    	
		    	if(ChoiceAction == 2 || ChoiceAction == -1) break;
		    	if(ChoiceAction == 0) {
		    		String input = JOptionPane.showInputDialog(" Enter liters to add: ");
		    		if(input != null) {
		    			int liters = Integer.parseInt(input);
		    			selectedTank.fill(liters);
		    			
		    		}
		    	} else if(ChoiceAction == 1) {
		    		String Input = JOptionPane.showInputDialog(" Enter liters to use: ");
		    		if(Input != null) {
		    			int liters = Integer.parseInt(Input);
		    			selectedTank.useWater(liters);
		    		}
		    	}
		    	JOptionPane.showMessageDialog(null, selectedTank.getTankname() + "\nCurrent Level: " + selectedTank.currentLvel + " L\nStatus: " + selectedTank.status());
		    	if(selectedTank.status().equals("full") || selectedTank.status().equals("Empty")) {
		    		JOptionPane.showMessageDialog(null, "Tank is at: " + selectedTank.status() + "The program will end. Thank you");
		    		break;
		    	}
		    }
		    
			
	}

}
		
