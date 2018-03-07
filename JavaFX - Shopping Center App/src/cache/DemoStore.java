package cache;

public class DemoStore {

	
		private static String st;

		public String getSt() {
			System.out.println("in return string "+st);
			
			return st;
		}

		public void setSt(String st) {
			this.st = st;
			System.out.println("in get string "+st);
		}
			
}
