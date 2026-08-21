package com.view;





import javax.swing.SwingUtilities;



public class StartUp {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AppLauncher app = new AppLauncher();
//				 try {
//					System.out.println(new File(".").getCanonicalPath());
//				 } catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				 }
//				Path p1 = Paths.get("/src/images");
//				System.out.println(FileSystems.getDefault().getPath("/src/images"));
//				System.out.println(p1.toAbsolutePath());
			}
		});
	}
}
