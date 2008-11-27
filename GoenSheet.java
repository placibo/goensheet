/*****************************************************************************
 * Copyright (c) 2004-2008 Javageo.com. All Rights Reserved.                 *
 *                                                                           *
 * This software is provided "AS IS," without a warranty of any kind.        *
 * You acknowledge that this software is not designed, licensed or intended  *
 * for use in the design, construction, operation or maintenance of any      *
 * nuclear facility.                                                         *
 * keep the world peace and green!                                           *
 *                                                                           *
 *@                                                                         **
 *@                                                                         **
 *@ JAVA       GoenSheet 1.0                                                **
 *@ Version#1.0 release 1                                                   **
 *@ By Javageo.com - Goen-Ghin                                              **
 *@ Date:  07-11-2008                                                       **
 *@ Pekanbaru Riau- Indonesia                                               **
 *****************************************************************************
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.text.rtf.*;
import javax.swing.undo.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.tree.*;
import java.awt.print.*; 
import javax.print.attribute.*; 
import javax.swing.text.rtf.*;
import javax.swing.undo.*;
import java.awt.datatransfer.*;
import javax.swing.table.*;
import java.awt.geom.Point2D;
import java.net.URL;

import org.jfree.data.xy.XYDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.annotations.XYImageAnnotation; 
import org.jfree.chart.ChartRenderingInfo; 
import org.jfree.chart.block.GridArrangement;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardXYToolTipGenerator;

import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.renderer.category.CategoryItemRenderer ;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.CategoryPlot;

//Report
import org.jfree.report.elementfactory.ShapeFieldElementFactory;
import org.jfree.report.JFreeReport;
import org.jfree.report.JFreeReportBoot;
import org.jfree.report.modules.parser.base.ReportGenerator;
//import org.jfree.report.demo.helper.ReportDefinitionException;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.report.modules.gui.base.PreviewDialog;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ObjectUtilities;
import org.jfree.report.ReportProcessingException;
import org.jfree.util.Log;
import org.jfree.report.elementfactory.TextFieldElementFactory;
import org.jfree.ui.FloatDimension;
import org.jfree.report.ElementAlignment;
import org.jfree.report.function.PageFunction;
import org.jfree.report.elementfactory.LabelElementFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import javax.swing.table.AbstractTableModel;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class GoenSheet extends JFrame implements ActionListener
{
	
  	public JFileChooser my_chooser;
 	public File my_FChoosen;
	public String my_OpenFile ="";
	public static final ImageIcon ICON_COMPUTER =new ImageIcon(ClassLoader.getSystemResource("folder.png"));
 	public static final ImageIcon ICON_FILES = new ImageIcon(ClassLoader.getSystemResource("kword.png"));
  	protected DefaultTreeModel myTreeModel;
	private JSplitPane  splitMe,splitMe2;
	private DefaultMutableTreeNode top;
	private File sourceDir,openRunwith;
	private JTree tree, myTree;
	
	public String treeSelect;
	private int indexHome=0;
 	
	public final JLabel statusBar;
	private JComboBox fontNamejb;
	private JComboBox fontSizejb;
	private JComboBox fontColorjb;
	private JComboBox fontBahasajb;

	private GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private String[]  fontNames = ge.getAvailableFontFamilyNames();
	
	private Canvas fontcanvas = new Canvas();
	private Canvas fontbgcanvas = new Canvas();
	private String font_file = "fontsetting.conf";
	private String set_fontName = "";
	private String set_bahasa = "";
	private int set_fontSize = 0;
	private Color cf = Color.black;
	private Color cb = Color.white;
	private JScrollPane ps;
	private String myhome;
	private ReadFontConfig ReadfnConf;
	private JScrollPane  treeSCPan;
 	private MyTextToolbar texttoolbar; 

	private TreePath selPath;
	public  JTextField outdirfile = new JTextField(20);
 	private JPanel myLeftPanel;
	private String setoutdir;
     
    public JPopupMenu popup;
    public JMenu chartPop;
    public JMenuItem menuPop,cutPop,clearPop, copyPop,pastePop, selectallPop, insertPop,deletePop, rowheightPop,
    selectrowPop,selectcolPop,addcolPop,remcolPop,inscolPop,renameColPop,selectcellPop, xychartPop,barchartPop,colwidthPop,previewPop;
    private JTable myTable;
    private SheetAdapter sheetCell;
    private JTable lineTable;
    private Vector rows,columns;
	private DefaultTableModel tabModel;
	
	private JPanel southPanel;
	private JLabel cellInfo;
    //Chart
    	private XYSeries series1;
    	private XYSeries seriescluster;
    	
	private XYSeriesCollection dataset;
	    private DefaultCategoryDataset bardataset;
	private XYDataset xydataset;
	private XYItemRenderer xyrenderer;
	private StandardXYItemLabelGenerator labelItem ;
	private JFreeChart chart;
	private ChartPanel chartPanel;
	
	private XYLineAndShapeRenderer renderer;	
	private XYPlot plot;
    private NumberAxis xAxis ,yAxis;
	
    private boolean xychartselect=false;
    
    //debase
    private static Properties goenDBprops;
	private static String sfile = "GoenDB.properties";
	private Connection con;
	private Statement stmt;
	private DatabaseMetaData md;
	private ResultSet rs; 
	private ResultSet mrs;
	private int rowData = 0;
	private int numTabel = 0;
	private int numRecord = 1;
	private static String myURL = "";
	private static String myDatabase = "";
	final JTextField driverTextfield = new JTextField(20);
	final JTextField urlTextfield = new JTextField(20);
	final JTextField databaseTextfield = new JTextField(20);
	final JTextField useridTextfield = new JTextField(20);
	final JTextField passwdTextfield = new JTextField(20);
	private JTextArea jtextArea;
 	public GoenSheet()
	{  
	super("GoenSheet ");

	new Splash().showSplash(5000);

	Toolkit kit = Toolkit.getDefaultToolkit();
	Image image = kit.getImage(ClassLoader.getSystemResource("logo.png"));
	setIconImage(image);
    UIManager.put("Tree.expandedIcon", new ImageIcon(ClassLoader.getSystemResource("open.png")));
    UIManager.put("Tree.collapsedIcon", new ImageIcon(ClassLoader.getSystemResource("closed.png")));
    //L&F Windows
     try {
    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
     } catch (Exception evt) {}
     
   java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();      


	Runtime r = Runtime.getRuntime();
    Properties p=System.getProperties();

 	myhome = (String)p.get("user.dir");
	ReadfnConf = new ReadFontConfig(myhome+File.separatorChar+font_file);
   
	 JPanel nortPanel = new JPanel();
	 nortPanel.setLayout(new GridLayout(1,2,3,3));
	 texttoolbar = new MyTextToolbar();
     nortPanel.add(texttoolbar);
        
     getContentPane().add(nortPanel,BorderLayout.NORTH); 	
        

	statusBar = new JLabel(" ");
    cellInfo = new JLabel("Row: | Col:", SwingConstants.RIGHT);

    southPanel = new JPanel();
    southPanel.setLayout(new GridLayout(1,2,7,7));
    southPanel.add(statusBar);
    southPanel.add(cellInfo);
	getContentPane().add(southPanel,BorderLayout.SOUTH);
	
	rows=new Vector();
	columns= new Vector();
	String[] columnNames = { "A","B","C","D","E","F","G","H","I","J"};
	addColumns(columnNames);
	
	tabModel=new DefaultTableModel();
	
	tabModel.setDataVector(rows,columns);
	
      	myTable = new JTable(tabModel);
      	
      	myTable.addKeyListener(new KeyAdapter() {
	public void keyPressed(KeyEvent e) 
	{
	if(!myTable.isEditing() && !e.isActionKey() &&!e.isControlDown() && !e.isAltDown() &&e.getKeyCode()!=KeyEvent.VK_SHIFT)
	 {
	 	int rowIndexStart = myTable.getSelectedRow();
	 	int colIndexStart = myTable.getSelectedColumn();
	 	if(rowIndexStart==-1 || colIndexStart==-1)return;
	 	myTable.editCellAt(rowIndexStart,colIndexStart);
	 	Component c = myTable.getEditorComponent();
	 	if(c instanceof JTextComponent)
	 	((JTextComponent)c).setText("");
	 	}
	 	}
	 	});
	 	
		
		lineTable = new RowLineNumberTable( myTable );
		sheetCell = new SheetAdapter(myTable);
		
		myTable.setCellSelectionEnabled(true);
		//Maybe someday we use it..
		//myTabel.setColumnSelectionAllowed(true);
		//myTabel.setRowSelectionAllowed(true) ;
	//	myTable.setSelectionBackground(Color.white);
	//	myTable.setSelectionForeground(Color.blue);
	//	myTable.setRowHeight(20);

		myTable.setDragEnabled(false) ;
		lineTable.setDragEnabled(false) ;
 
	 //	myTable.setShowVerticalLines(true) ;
       //myTable.setShowGrid(boolean showGrid) 
       myTable.setShowGrid(true) ;
       myTable.setGridColor(Color.blue) ;
     //  myTable.setGridColor(Color gridColor) 
     
 		ps = new JScrollPane(myTable);
 		ps.setRowHeaderView( lineTable );


		ps.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		ps.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(ps, BorderLayout.CENTER);
 		
        setFontAttributte();
    
         popup = new JPopupMenu(); 
         
 		 popup.add(cutPop = new JMenuItem("Cut"));
		 popup.add(copyPop = new JMenuItem("Copy"));
		 popup.add(pastePop = new JMenuItem("Paste"));
		 popup.add(clearPop = new JMenuItem("Clear"));
		 popup.addSeparator();

		 popup.add(insertPop = new JMenuItem("Insert Row"));
		 popup.add(deletePop = new JMenuItem("Delete Row"));
		 popup.add(renameColPop = new JMenuItem("Rename Column"));
		 popup.add(addcolPop = new JMenuItem("Add Column"));
		 popup.add(inscolPop = new JMenuItem("Insert Column"));		 
		 popup.add(remcolPop = new JMenuItem("Remove Column"));
		 
		 		 
		 popup.addSeparator();

		 popup.add(selectallPop = new JMenuItem("Select All"));
		 popup.add(selectrowPop = new JMenuItem("Select Row"));
		 popup.add(selectcolPop = new JMenuItem("Select Column"));
		 popup.add(selectcellPop = new JMenuItem("Select Cell"));
		 
		 
		 inscolPop.addActionListener(new MyMenuListener());
		 
		 
		 
		 selectrowPop.addActionListener(new MyMenuListener());
		 selectcolPop.addActionListener(new MyMenuListener());
		 selectcellPop.addActionListener(new MyMenuListener());
		 popup.addSeparator();

		 popup.add(rowheightPop = new JMenuItem("Row Height"));
		 popup.add(colwidthPop = new JMenuItem("Column Width"));
		 popup.addSeparator();
		 popup.add(chartPop = new JMenu("Chart"));
		 chartPop.add(xychartPop = new JMenuItem("XY Chart"));
		 chartPop.add(barchartPop = new JMenuItem("Bar Chart"));		 
		 popup.add(previewPop = new JMenuItem("Print Preview"));
		 xychartPop.addActionListener(new MyMenuListener());
		 barchartPop.addActionListener(new MyMenuListener());
		 previewPop.addActionListener(new MyMenuListener());
		 colwidthPop.addActionListener(new MyMenuListener());
		
		 renameColPop.addActionListener(new MyMenuListener());
		 cutPop.addActionListener(new MyMenuListener());
		 clearPop.addActionListener(new MyMenuListener());
		 copyPop.addActionListener(new MyMenuListener());
		 pastePop.addActionListener(new MyMenuListener());
		 selectallPop.addActionListener(new MyMenuListener());
 		 rowheightPop.addActionListener(new MyMenuListener());
 		 insertPop.addActionListener(new MyMenuListener());
 		 addcolPop.addActionListener(new MyMenuListener());
 		 deletePop.addActionListener(new MyMenuListener());
 		 remcolPop.addActionListener(new MyMenuListener());
 		 myTable.setComponentPopupMenu(popup);

     top = new DefaultMutableTreeNode(new IconData(ICON_COMPUTER, null, "My Project  "));
    myTreeModel = new DefaultTreeModel(top);
     
     //Read Working Directory
     try {
     sourceDir = new File(ReadfnConf.getWorkingDir());
     
     if(sourceDir == null) sourceDir = new File(myhome); 
     else sourceDir = new File(""+ReadfnConf.getWorkingDir());
     	setCurrentFile(sourceDir);

		File[] roots = sourceDir.listFiles();
		//Put Working Directory's file in JTree
		for (int k=0; k < roots.length; k++)
		{
		 myTreeModel.insertNodeInto(new DefaultMutableTreeNode(new IconData(ICON_FILES,null, roots[k].getName())),top,k);
 		}
         }catch(Exception ex){warnme("Working Directory Not Found");}
  
		myTree = new JTree(myTreeModel);
        myTree.setSelectionRow(0) ;
        myTree.putClientProperty("JTree.lineStyle", "Angled");
        
        //Add JTree listener
        myTree.addTreeSelectionListener(new TreeSelectionListener()
	   {
		public void valueChanged(TreeSelectionEvent te)
		{ 
		   try {
		   	
		   selPath = te.getNewLeadSelectionPath();
 		   if(selPath != null) {
		       String treeSelect = selPath.getLastPathComponent().toString();
               //This for windows file 
               if(treeSelect.startsWith("C:")) my_OpenFile = treeSelect;
               
               else
                  my_OpenFile = sourceDir.getAbsolutePath()+File.separator+treeSelect; 
               
                statusBar.setText(""+my_OpenFile);
             }
   
 	       }catch (Exception ex) {
	       	warnme("Error select file directory "+ex);
	       	}
		   
			}
		}
	   );
	  
	   //Add Mouse Listener
	   MouseListener mouseListener = new MouseAdapter()
			{
				public void mouseClicked (MouseEvent e)
				{
					int selRow = myTree.getRowForLocation(e.getX(), e.getY());
                    selPath = myTree.getPathForLocation(e.getX(), e.getY());
                     
                  if(selRow != -1) {
                    	if (e.getClickCount() == 1)
					   {
  		                //Already handle by  TreeSelectionListener
 						//none
						}
					if (e.getClickCount() == 2)
					   {
						// If file is directory show list files on panel
						 removeTable();
						openSheetFile(myTable,new File(my_OpenFile));
	
 			            }
			        	}
				}
			};
		//Add Mouse listener in JTree
 		myTree.addMouseListener(mouseListener);
 		 //Add Mouse Listener
	   KeyListener keyListener = new KeyListener()
			{
                 int rowcell;
                 int colcell;
                 String strVal;
				public void keyPressed (KeyEvent e)
				{
   				}
 				public void keyReleased (KeyEvent e){
	            ambilCell();
	            
 					}
 				public void keyTyped (KeyEvent e){}
 				public void keyDown (KeyEvent e){}
 				public void keyRight (KeyEvent e){}
 				public void keyLeft (KeyEvent e){}
 				public void keyUp (KeyEvent e){}
 				
 				public void ambilCell()
 				{
 					//For Info
                     rowcell = myTable.getSelectedRow() + 1;
                     colcell = myTable.getSelectedColumn() + 1;
                 //    if(rowcell == 0 && colcell == 0) {rowcell=1;colcell=1;}
                      strVal = (String)myTable.getValueAt(rowcell-1, colcell-1);
 					cellInfo.setText("Row:"+rowcell+" , Col:"+colcell+" , Value= "+strVal);

 					}
			};
		//Add Key listener in JTree
 		myTable.addKeyListener(keyListener);
			
 	   //Add Mouse Listener
	   MouseListener tablemouseListener = new MouseAdapter()
			{
				public void mouseClicked (MouseEvent e)
				{
                     int rowcell;
                     int colcell;
                     String strVal="";
                    	if (e.getClickCount() == 1)
					   {
					 rowcell = myTable.getSelectedRow() + 1;
                     colcell = myTable.getSelectedColumn() + 1;
  		                //Already handle by  TreeSelectionListener
 						//none 			
 					 		
 					strVal = (String)myTable.getValueAt(rowcell-1, colcell-1);
 					cellInfo.setText("Row:"+rowcell+" , Col:"+colcell+" , Value= "+strVal);

						}
					if (e.getClickCount() == 2)
					   {
						// If file is directory show list files on panel
  			            }
			        	
				}
			};
			 		//Add Mouse listener in JTree
 		myTable.addMouseListener(tablemouseListener);

        //JTree renderer
		TreeCellRenderer renderer = new	IconCellRenderer();
		myTree.setCellRenderer(renderer);
		myTree.getSelectionModel().setSelectionMode(
		TreeSelectionModel.SINGLE_TREE_SELECTION); 
		myTree.setShowsRootHandles(true); 
		myTree.setEditable(false);
 
    //Put JTree in Left and JEditorPane in Right
    treeSCPan = new JScrollPane();
    treeSCPan.getViewport().add(myTree);
    	
    splitMe = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeSCPan, ps);
    splitMe.setMinimumSize(new Dimension(150, 170));
    splitMe.setOneTouchExpandable(true) ;
    splitMe.setResizeWeight(0.2) ;
    splitMe.setDividerSize(17) ;
    
     xydataset = createDataset();
	
 	
    chart = createChart(xydataset,"XY Line Chart");
    chartPanel = new ChartPanel(chart);
    chartPanel.setPreferredSize(new java.awt.Dimension(50, 270));
    chartPanel.setVisible(false);
    
    splitMe2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitMe, chartPanel);
    splitMe2.setMinimumSize(new Dimension(80, 170));
    splitMe2.setOneTouchExpandable(true) ;
    splitMe2.setResizeWeight(0.2) ;
    splitMe2.setDividerSize(17) ;

    //Put SplitPane in Center
    getContentPane().add(splitMe2, BorderLayout.CENTER);
    
   
    
	//getContentPane().add(chartPanel, BorderLayout.EAST);


    //This is simple menubar..you can make another advance menubar
    JMenuBar menuBar = createMenuBar();
	setJMenuBar(menuBar);
	// This is FileChooser initialization
	my_chooser = new JFileChooser(); 
    my_chooser.setCurrentDirectory(new File(".")); 
    
    //Open New Sheet
    addRow(30);

   setSize(750, 500);
   setLocation((screenSize.width-750)/2,(screenSize.height-500)/2);
   RepaintManager.currentManager(this).setDoubleBufferingEnabled(false);
   setVisible(true);
	
		}
     //menu..menu..menu 
		protected JMenuBar createMenuBar()
	{
		final JMenuBar menuBar = new JMenuBar();
		
		JMenu mFile = new JMenu("File");
		mFile.setMnemonic('F');

		JMenuItem item = new JMenuItem("New");
		item.setMnemonic('N');
		ActionListener lst = new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e)
			{
		            removeTable();
                    addRow(30);
			}
		};
		item.addActionListener(lst);
		mFile.add(item);

		item = new JMenuItem("Open...");
		item.setMnemonic('O');
		lst = new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e)
			{				
        Thread runner = new Thread() {
                     public void run() {
    if (my_chooser.showOpenDialog(GoenSheet.this) !=  JFileChooser.APPROVE_OPTION) return;
            GoenSheet.this.repaint();
            my_FChoosen = my_chooser.getSelectedFile();
            
            my_OpenFile = my_chooser.getSelectedFile().toString();
            
            openSheetFile(myTable, my_FChoosen);
 
                  }
               };
                  runner.start();
			}
		};
		item.addActionListener(lst);
		mFile.add(item);

		item = new JMenuItem("Save As...");
		item.setMnemonic('A');
		lst = new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e)
			{
				
            GoenSheet.this.repaint();
	
              Thread runner = new Thread() {
              public void run() {
			 	    
		            saveSheetFile(myTable);
		            
                      }
                    };
                    runner.start();
			}
		};
		item.addActionListener(lst);
		mFile.add(item);

		mFile.addSeparator();
				
		item = new JMenuItem("Print");
		item.setMnemonic('P');
		lst = new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e)
			{
                
                     Thread runner = new Thread() {
                                  public void run() {
                                  	
            	PrintFile pfile = new PrintFile(myTable);
 			 	  
                                 }
                                };
                                runner.start();
			}
		};
		item.addActionListener(lst);
		
		mFile.add(item);
		
		item = new JMenuItem("Print Preview");
		item.setMnemonic('v');
		lst = new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e)
			{
                
                     Thread runPreview = new Thread() {
                                  public void run() {
                                  	
            	try{
					previewData();
					}catch(Exception ex){warnme("error..."+ex);}
 			 	  
                                 }
                                };
                                runPreview.start();
			}
		};
		item.addActionListener(lst);
		
		mFile.add(item);

		mFile.addSeparator();
		
		item = new JMenuItem("Export to CSV Format");
		item.setMnemonic('E');
		lst = new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e)
			{
                
            Thread runner = new Thread() {
            public void run() {
	        try {
				if (my_chooser.showSaveDialog(GoenSheet.this) !=  JFileChooser.APPROVE_OPTION) return;
				GoenSheet.this.repaint();
				my_FChoosen = my_chooser.getSelectedFile();
				
				my_OpenFile = my_chooser.getSelectedFile().toString();
				
				ExportertoFile exp = new ExportertoFile();
				exp.exportTable(myTable, new File(my_OpenFile));
       
    }
    catch (IOException ex) { warnme(""+ex.getMessage());   }
             //view 
               }
            };
            runner.start();
			}
		};
		item.addActionListener(lst);
		
		mFile.add(item);
		item = new JMenuItem("About GoenSheet 1.0.3");
		item.setMnemonic('G');
		 lst = new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e)
			{
				JFrame frame = new JFrame("About GoenSheet 1.0.3");
				ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("logo.png"));
		        JLabel label1 = new JLabel(icon);
		
		        frame.add("North",label1);
		
		        JLabel label2 = new JLabel("<html><li>GoenSheet - A Simple SpreadSheet™ "
		        + "</li><li><p>Ver# 1.0.3 </li>"
		        + "<li><p>Develop by: JavaGeo.com</li><li>"
		        + "<p>Copyright<font size=\"2\">©</font> August 2008 @Pekanbaru Riau Indonesia</li></html>");
		
		label2.setFont(new Font("Tahoma", Font.PLAIN, 11));		
		frame.add(label2);
			  	      
	       Toolkit kit = Toolkit.getDefaultToolkit();
		   Image image = kit.getImage(ClassLoader.getSystemResource("logo.png"));
		   frame.setIconImage(image);
				 
			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();      
    		frame.setSize(new java.awt.Dimension(240, 150));
    		frame.setLocation((screenSize.width-240)/2,(screenSize.height-240)/2);
    		frame.setVisible(true);
 
			}
		};
		item.addActionListener(lst);
        mFile.add(item);
        
		item = new JMenuItem("Exit");
		item.setMnemonic('x');
		lst = new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		};
		item.addActionListener(lst);
		mFile.add(item);
		menuBar.add(mFile);

		return menuBar;
	}
	
     	public void actionPerformed(ActionEvent ae) {	}
  		
		//end menu
		//font setting
  public JPanel JPanelFontOpen( final JFrame j)
		{  
		final JPanel myPanel = new JPanel();  
		myPanel.setLayout(new BorderLayout());
		myPanel.setBorder(new TitledBorder(new EtchedBorder(),"Option"));
		JFileChooser filechooser;
	 
 	  JPanel myLabelPanel = new JPanel();

	  JLabel fontNameLabel = new JLabel(" Font Name: ");
	  JLabel fontSizeLabel = new JLabel(" Font Size: ");
	  JLabel fontColorLabel = new JLabel(" Font Color: ");
	  JLabel fontBgColorLabel = new JLabel(" Background Color: ");
 	  JLabel outdirLabel = new JLabel(" Project Directory : ");
       
	  JPanel myTextFieldPanel = new JPanel();
	
	  JTextField fontName = new JTextField();
	  JTextField fontColor = new JTextField();
	  JTextField fontSize = new JTextField();
  	
	  JPanel myButtondPanel = new JPanel();
	
	  JButton fontColorButton;
	  JButton fontBackgroundButton;
	  JButton brosCurvebutton;
	  JButton applyButton;
	  JButton closeButton;
	  JButton brosoutdirbutton;
 
	  ReadfnConf = new ReadFontConfig(myhome+File.separatorChar+font_file);
	   
	  myLabelPanel.setLayout(new GridLayout(6, 1, 5, 15));
	    	    
	    myLabelPanel.add(fontColorLabel);
	    myLabelPanel.add(fontBgColorLabel);
	    myLabelPanel.add(fontNameLabel);
	    myLabelPanel.add(fontSizeLabel);
	    myLabelPanel.add(outdirLabel);
   	   
	    myPanel.add("West", myLabelPanel);
	    
	    myTextFieldPanel.setLayout(new GridLayout(6, 1, 5, 5));
	    
	    fontNamejb = new JComboBox();
  	     
	    for(int a=0;a<fontNames.length;a++)
	    {
	     fontNamejb.addItem(fontNames[a]);
	    }	    
	    
	    fontBahasajb = new JComboBox();
 	 
	    fontSizejb = new JComboBox(new String[] {"10", 
      "11", "12", "14", "16", "18", "20", "22", "24", "26", 
      "28", "36", "48", "72"});
      
     
	   fontcanvas = new Canvas();
	   fontbgcanvas =new Canvas();
	   
	    myTextFieldPanel.add(fontcanvas);
	    myTextFieldPanel.add(fontbgcanvas);
	    myTextFieldPanel.add(fontNamejb);
	    myTextFieldPanel.add(fontSizejb);
	    
	    outdirfile.setText(""+ReadfnConf.getWorkingDir());

 	    myTextFieldPanel.add(outdirfile);
 	    
	    myPanel.add("Center", myTextFieldPanel);
	    
	    myButtondPanel.setLayout(new GridLayout(6, 1, 5, 5));
	    
	    fontColorButton = new JButton("..");
	    fontColorButton.addActionListener(this);
	    fontBackgroundButton = new JButton("..");
	    fontBackgroundButton.addActionListener(this);
	    
	    myButtondPanel.add(fontColorButton);	    
	    myButtondPanel.add(fontBackgroundButton);
	    
	    JLabel jl1 = new JLabel("");
	    JLabel jl2 = new JLabel("");
	    
	    myButtondPanel.add(jl1);
	    myButtondPanel.add(jl2);
	    
	    brosoutdirbutton = new JButton("..");
	    myButtondPanel.add(brosoutdirbutton);
	    brosoutdirbutton.addActionListener(this);
  
	    myPanel.add("East",myButtondPanel);
	    
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new GridLayout(1, 4, 5, 5));
	    
	    applyButton = new JButton("Apply");
	    applyButton.addActionListener(this);
	    
	    JButton defaultButton= new JButton("Default");
		defaultButton.addActionListener(this);
		    
		JButton resetButton= new JButton("Reset");
		resetButton.addActionListener(this);
	    
	    closeButton = new JButton("Close");
	    closeButton.addActionListener(this);
	    
	    
	    buttonPanel.add(applyButton);
	    buttonPanel.add(defaultButton);
	    buttonPanel.add(resetButton);
	    buttonPanel.add(closeButton);
	    myPanel.add("South", buttonPanel);
	    applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
               setoutdir=outdirfile.getText();
            
				Font fn = new Font(ReadfnConf.getFontName(), Font.PLAIN, ReadfnConf.getFontSize());
				set_fontName = fontNamejb.getSelectedItem().toString();
				
				int fontSize = Integer.parseInt(fontSizejb.getSelectedItem().toString());
				set_fontSize = fontSize;
				
				
				myTable.setFont(new Font(set_fontName, Font.PLAIN, set_fontSize));
				
				myTable.setForeground(cf);
				myTable.setBackground( cb);
				    
				myTable.repaint(); 
				       	
 				try{ 	       	
				    FileOutputStream outfo = new FileOutputStream(font_file);
				    DataOutputStream outst = new DataOutputStream(outfo);
			   
				    outst.writeUTF(" "+"\n"+
				    "FontName:"+set_fontName+"\n"+
				    "FontSize:"+set_fontSize+"\n"+
				    "FontColor:"+cf.getRGB()+"\n"+
				    "FontBgColor:"+cb.getRGB()+"\n"+
				    "WorkingDir:"+setoutdir+"\n");;
 
				    outst.close();
				    outfo.close();
				    
				    addNewFile(setoutdir);
				    
			   }catch (Exception ex){};
				
				j.setVisible(true);
				//show();
                  }     
         }); 
        
        defaultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	fontNamejb.setSelectedItem("Arial");
				fontSizejb.setSelectedItem(12);
				fontcanvas.setBackground(Color.black);
				fontbgcanvas.setBackground(Color.white);
 				repaint();
            }
        });
        
        resetButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
         
         ReadfnConf = new ReadFontConfig(font_file);        		     
		 fontNamejb.setSelectedItem(ReadfnConf.getFontName());
		 fontSizejb.setSelectedItem(ReadfnConf.getFontSize());	 		 		 
		 fontcanvas.setBackground(new Color(ReadfnConf.getFontColor()));
		 fontbgcanvas.setBackground(new Color(ReadfnConf.getFontBgColor()));
            
            }
        });
        
	    closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 j.dispose();
            
                       }
        }); 
        
        brosoutdirbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            JFileChooser chooser = new JFileChooser(".");    
           chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
           File file = new File(".");
              
        if (chooser.showDialog(myPanel, "Select") == 
			JFileChooser.APPROVE_OPTION)
		{
		        file = chooser.getSelectedFile();       
		        outdirfile.setText(file.getPath());     
		        sourceDir = file;
	     }
            }
        }); 
 
		fontColorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            cf = JColorChooser.showDialog(
                   ((Component)null),
                  "set Font Color", Color.blue);
                  fontcanvas.setBackground(cf); 
                  if(cf == null) fontbgcanvas.setBackground(Color.white); 
                       }
        }); 
        
        fontBackgroundButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            	cb = JColorChooser.showDialog(((Component)null),
                  "set Font Background Color", Color.blue);
                  fontbgcanvas.setBackground(cb); 
					   
					   if(cb == null) fontbgcanvas.setBackground(Color.blue); 
            
                       }
        }); 
		
		fontSetOpen(myhome+File.separatorChar+font_file);
		return myPanel;
	}


protected void addNewFile(String filename)
{
	//add  
				    // Remove all top Nodes
 				 	top.removeAllChildren();
				    top.removeFromParent();
                     
					myTreeModel.reload(); 
                  
                 //Add Files 
				 sourceDir = new File(""+filename);
				 if(!sourceDir.exists()) warnme("Not Found "+filename);
                else if(sourceDir != null || sourceDir.exists())
                {

				 File[] roots = sourceDir.listFiles();
		        
				for (int k=0; k < roots.length; k++)
				{
					
				 myTreeModel.insertNodeInto(new DefaultMutableTreeNode(new IconData(ICON_FILES,null, roots[k].getName())),top,k);

				}
				  // To make JTree expand on row 0
				myTree.expandRow(0) ;
                myTree.repaint();  
                 }          
 				setCurrentFile(sourceDir);
	
	}
	
protected void setCurrentFile(File file) {
		if (file != null) {
 		  setTitle("GoenSheet 1.0 [ Working Project :"+file.getPath()+"]");
		}
		}	 	

			//set font setting
public void setFontAttributte()
{
	ReadfnConf = new ReadFontConfig(myhome+File.separatorChar+font_file); 
   	myTable.setFont(new Font(ReadfnConf.getFontName(), Font.PLAIN, ReadfnConf.getFontSize()));
  	myTable.setForeground(new Color(ReadfnConf.getFontColor()));
 	myTable.setBackground(new Color(ReadfnConf.getFontBgColor()));
 	
	}
	//set open file font setting
public void fontSetOpen(String configFile)
		{
			
 	     ReadfnConf = new ReadFontConfig(myhome+File.separatorChar+font_file);        		     
		 fontNamejb.setSelectedItem(ReadfnConf.getFontName());
		 fontSizejb.setSelectedItem(ReadfnConf.getFontSize());	 		 		 
		 fontcanvas.setBackground(new Color(ReadfnConf.getFontColor()));
		 fontbgcanvas.setBackground(new Color(ReadfnConf.getFontBgColor()));
  				
		}

public void runChartDialog()
{
	try {
					ChartDataDialog cDataDialog = new ChartDataDialog(GoenSheet.this);
				    Dimension d1 = cDataDialog.getSize();
				    Dimension d2 = GoenSheet.this.getSize();
				    int xv = Math.max((d2.width-d1.width)/2, 0);
				    int yv = Math.max((d2.height-d1.height)/2, 0);
				    cDataDialog.setBounds(xv + GoenSheet.this.getX(),
				      yv + GoenSheet.this.getY(), d1.width+90, d1.height-50);								    
				    cDataDialog.setVisible(true);														
					}
					catch (Exception e) {
						warnme("Error due to " + e.getMessage());										
						}  
	}	

public void connectDB(String queryText)
{
 	 //remove all rows first
 	 removeTable();
 	 //add new headers
 	 addColumn();
 	 
 	 //container
 	 Vector row = new Vector(); 	 
     String columnName =" ";
    try {
		con = getConnection();      
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE ,
		                         ResultSet.CONCUR_READ_ONLY);
		
		rs = stmt.executeQuery(queryText);
		ResultSetMetaData rsmd = rs.getMetaData();
		
		String[] record = new String[rsmd.getColumnCount()];
		
    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
          columnName = rsmd.getColumnName(i);
         changeName(myTable,i-1,columnName);
          }
           
		while (rs.next()) {    
		row = new Vector(); 
		for (int i=1; i <= rsmd.getColumnCount(); i++) {
		columnName = rs.getString(i);
		row.addElement(columnName); 
		}
		tabModel.addRow(row);  
		}
		
     	myTable.addNotify();
        
    } catch (Exception e) {
      warnme("error database "+e);
    }
	
	}

public static Connection getConnection() throws SQLException, IOException {
    goenDBprops = new Properties();
    
    FileInputStream in = new FileInputStream(sfile);
    goenDBprops.load(in);

    String drivers = goenDBprops.getProperty("jdbc.drivers");
    if (drivers != null)
      System.setProperty("jdbc.drivers", drivers);
      
     myDatabase = goenDBprops.getProperty("jdbc.database");
    myURL = goenDBprops.getProperty("jdbc.url");
    String username = goenDBprops.getProperty("jdbc.username");
    String password = goenDBprops.getProperty("jdbc.password");

    return DriverManager.getConnection(myURL+myDatabase, username, password);
  }

public void insertColumn(JTable table,int col_Index) {
	int columns = table.getColumnCount();
	if (columns > 0) {
        myTable.moveColumn(table.getColumnCount()-1, col_Index);
        myTable.addNotify();
    }
   
  }
  
  	
public void addColumns(String[] colName)//Table Columns
	{
	for(int i=0;i<colName.length;i++)
	columns.addElement((String) colName[i]);
	}

public void addColumn() {
		String header = "";
		tabModel.addColumn(header);
		myTable.addNotify();
	}
	
public void changeName(JTable table, int col_index, String col_name){
    myTable.getColumnModel().getColumn(col_index).setHeaderValue(col_name);
  }
		
public void removeLastColumn() {
		 int columnsize = myTable.getColumnCount();
 		
		int columns = myTable.getSelectedColumns()[0];

		if (columnsize > 0) {
			if (!myTable.getAutoCreateColumnsFromModel()) {
				int view = myTable.convertColumnIndexToView(columnsize - 1);
 				if (view > 0) {
 					TableColumn column = myTable.getColumnModel().getColumn(view);
					myTable.getColumnModel().removeColumn(column);
				} else {
					warnme("view is < 0");
				}
			}
 			tabModel.setColumnCount(columnsize - 1);
		}
	}
	public void setColumnWidth(int columnIndex, int width) {
		myTable.getColumnModel().getColumn(columnIndex).setPreferredWidth(width);
		 
	}
	public void setAllColumnWidth(int width) {
		for (int i = 0; i < myTable.getColumnCount(); i++) {
			setColumnWidth(i, width);
		}
	}
public void addRow(int newSize) //Add Row
	{
	Vector r=new Vector();
	r.setSize(newSize);
	for(int i=0;i<newSize;i++)
	{
		
	r=createBlankElement();
	rows.addElement(r);
	
	myTable.addNotify();
    }
	
	}
	//Create blank
public Vector createBlankElement() 
	{
	Vector t = new Vector();
		
	t.addElement((String) " ");
	t.addElement((String) " ");
	t.addElement((String) " ");
	t.addElement((String) " ");
	t.addElement((String) " ");
	t.addElement((String) " ");
	t.addElement((String) " ");
	t.addElement((String) " ");
	t.addElement((String) " ");
	t.addElement((String) " ");
 	
	return t;
	}
void deleteRow(int index) 
	   {
	     if(index!=-1)//At least one Row in Table
	      { 
	      	rows.removeElementAt(index);

	        myTable.addNotify();
	       }
	
	   }//Delete Row
 
	   
void insertRow(int index) 
	   {
	     if(index!=-1)//At least one Row in Table
	      { 
	        rows.add(index,createBlankElement());
	        myTable.addNotify();
	        lineTable.addNotify();
	       }
	
	   }//Delete Row
void insertRows(int[] index, int selrow) 
	   {
	     if(index[0]!=-1)//At least one Row in Table
	      { for (int i=0;i<index.length ;i++)
	        rows.add(selrow+i,createBlankElement());
	        myTable.addNotify();
	        lineTable.addNotify();
	       }
	
	   }//Delete Rows
	   
	
	
void setSetting()
  {
  	
  				Thread optionrun = new Thread() {
				public void run() {
				
			try {
				
			JFrame frame = new JFrame("Set Configuration");
				
			         frame.setContentPane(JPanelFontOpen(frame)) ;
			         Toolkit kit = Toolkit.getDefaultToolkit();
					 Image image = kit.getImage(ClassLoader.getSystemResource("logo.png"));
					 frame.setIconImage(image);
 			         
			 java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();      
    		frame.setSize(new java.awt.Dimension(370, 270));
    		frame.setLocation((screenSize.width-370)/2,(screenSize.height-270)/2);
    		frame.setVisible(true);
     	   	
    	   	    
    	   	}	catch (Exception e) { warnme("Error due to " + e.getClass() + e.getMessage());/* handle exception */ }     		
						
		      }
			};
			optionrun.start();
  	
  	}
  	
  	//Connection setting
  public JPanel JPanelSetting( final JFrame j)
		{  
		final JPanel MyPanel = new JPanel();  
		MyPanel.setLayout(new BorderLayout());
		MyPanel.setBorder(new TitledBorder(new EtchedBorder(), 
		  "Option"));
		JFileChooser filechooser;
		
		JPanel MyLabelPanel = new JPanel();
		
		JLabel driverLabel = new JLabel(" Driver : ");
		JLabel urlLabel = new JLabel(" URL : ");
		JLabel databaseLabel = new JLabel(" Database : ");
		JLabel useridLabel = new JLabel(" User Name: ");
		JLabel passwdLabel = new JLabel(" Password: ");
		
		JPanel MyTextFieldPanel = new JPanel();
	
	    MyLabelPanel.setLayout(new GridLayout(5, 1, 5, 5));
	    MyLabelPanel.add(driverLabel);
	    MyLabelPanel.add(urlLabel);
	    MyLabelPanel.add(databaseLabel);
	    
	    MyLabelPanel.add(useridLabel);
	    MyLabelPanel.add(passwdLabel);
	    
	    MyPanel.add("West", MyLabelPanel);
	    
	    MyTextFieldPanel.setLayout(new GridLayout(5, 1, 5, 5));
	    MyTextFieldPanel.add(driverTextfield);
	    MyTextFieldPanel.add(urlTextfield);
	    MyTextFieldPanel.add(databaseTextfield);
	    MyTextFieldPanel.add(useridTextfield);
	    MyTextFieldPanel.add(passwdTextfield);
	    
	    MyPanel.add("East", MyTextFieldPanel);
	    
	    JPanel ButtonPanel = new JPanel();
	    ButtonPanel.setLayout(new GridLayout(1, 4, 5, 5));
	    
	    JButton ApplyButton = new JButton("Apply");
	    ApplyButton.addActionListener(this);
	    
	    JButton DefaultButton= new JButton("Default");
		DefaultButton.addActionListener(this);
		    
		JButton ResetButton= new JButton("Reset");
		ResetButton.addActionListener(this);
	    
	    JButton CloseButton = new JButton("Close");
	    CloseButton.addActionListener(this);
	    
 	    ButtonPanel.add(ApplyButton);
	    ButtonPanel.add(DefaultButton);
	    ButtonPanel.add(ResetButton);
	    ButtonPanel.add(CloseButton);
	    
	    jtextArea = new JTextArea();
	    jtextArea.setText("select * from Program");
	    
	    JPanel QueryPanel = new JPanel();
	    QueryPanel.setBorder(new TitledBorder(new EtchedBorder(), "Query")); 
	    QueryPanel.setLayout(new BorderLayout());
	    JScrollPane scrollpane = new JScrollPane(jtextArea);
	    QueryPanel.add("Center",scrollpane);
	    QueryPanel.add("South",ButtonPanel);
	    
	    MyPanel.add("South", QueryPanel);
	    
	    ApplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
            saveSetting();
            
            connectDB(jtextArea.getText());
      	
              }
        }); 
        
        DefaultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
             
            loadSetting();
            
            }
        });
        
        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
         
            driverTextfield.setText("");
		    urlTextfield.setText("");
		    databaseTextfield.setText("");
		    useridTextfield.setText("");
		    passwdTextfield.setText("");          	
         
            }
        });
        
	    
	    CloseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	 j.dispose();
            
                       }
        }); 
		
		
	 loadSetting();
		
		return MyPanel;
		
	}		
   public void warnme(String message) {
    JOptionPane.showMessageDialog(new JFrame(), 
      message, "Warning", JOptionPane.INFORMATION_MESSAGE);
  }
  public void loadSetting()
	{
	try {
			goenDBprops = new Properties();
		    FileInputStream in = new FileInputStream(sfile);
		    goenDBprops.load(in);		    
		    driverTextfield.setText(goenDBprops.getProperty("jdbc.drivers"));
		    urlTextfield.setText(goenDBprops.getProperty("jdbc.url"));
		    databaseTextfield.setText(goenDBprops.getProperty("jdbc.database"));
		    useridTextfield.setText(goenDBprops.getProperty("jdbc.username"));
		    passwdTextfield.setText(goenDBprops.getProperty("jdbc.password"));
		    }catch (Exception ex) {warnme(""+ex.getMessage());}
      }
      
  public void saveSetting()
	{
		try
				    {			  
				  
			       FileOutputStream outfl = new FileOutputStream(sfile);
			       goenDBprops.setProperty("jdbc.drivers",driverTextfield.getText());
		           goenDBprops.setProperty("jdbc.url",urlTextfield.getText());
		           goenDBprops.setProperty("jdbc.database",databaseTextfield.getText());
		           goenDBprops.setProperty("jdbc.username",useridTextfield.getText());
		           goenDBprops.setProperty("jdbc.password",passwdTextfield.getText());
			       goenDBprops.save(outfl,"GoenDB Ver 1.0 Pekanbaru 2007 - Properties File ");
			       outfl.close();
				    } 
				    catch (IOException ex) 
				    {
					warnme(""+ex.getMessage());
				    }	 
	    
		}
 
	protected void saveSheetFile(JTable mytabel)
	{
		
		int returnVal = my_chooser.showSaveDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			try
			{ 				    

				FileWriter fwriter = new FileWriter(my_chooser.getSelectedFile());
				BufferedWriter bwriter = new BufferedWriter(fwriter);
                TableModel model = mytabel.getModel();
                
            try
          {
             for (int i=0;i<model.getRowCount();i++)
             {
            for (int j=0;j<model.getColumnCount();j++)
               {
                if(j==0) {
 			     bwriter.write(mytabel.getValueAt(i,j)+ "|");
			   } else {
   			     bwriter.write("|"+mytabel.getValueAt(i,j)+ "|");
 			   }
              }
             bwriter.write("\n");
          }
         }
            catch(Exception ex){
            	//ex.printStackTrace();
            	warnme("Please Check Data");
            	 }
 				bwriter.close();
			}
			catch (IOException ioe)
			{
				//ioe.printStackTrace();
					warnme("Please Check File");
			}
		}

	}
	
protected void removeTable()
	{
		rows.clear();
		
		}
 protected void openSheetFile(JTable mytabel, File fileToLoad)
	{
		//remove first
		removeTable();
				try		{   
                 Vector data = new Vector();
                  String aLine;
                
                  FileInputStream fis = new FileInputStream(fileToLoad);
                  BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                    
                 // read each line of the file
                while ((aLine = br.readLine()) != null) {
                 // create a vector to hold the field values
                      Vector row = new Vector();
                 // tokenize line into field values
                     StringTokenizer st = new StringTokenizer(aLine, "|");
                      while (st.hasMoreTokens()) {
                                                                                                          // add field to the row
                          row.addElement(st.nextToken());
                          }
   
                      // add row to the model
                     tabModel.addRow(row);
                 }
   // Close file
          br.close();
          fis.close();
    				
    				}
    				catch (IOException ioExc){
					}
					
	}
	public void readBarPoint( ) 
  	{
  		try
  		{ 
   		
  		 //For Data X Y get from Table
       int xcolcell = myTable.getSelectedColumn() ;
       int ycolcell = myTable.getSelectedColumn() + 1;
       
       
       int sizeCol = myTable.getRowCount()  ;
       //System.out.println("CX="+xcolcell+" CY="+ycolcell+"S="+sizeCol);

          try
          {
                  for(int j=0;j<sizeCol;j++)
                {
                      double x = (double)Double.valueOf(myTable.getValueAt(j, xcolcell).toString()) ;
                      String y = String.valueOf(myTable.getValueAt(j, ycolcell).toString()); 
                      String z = String.valueOf(myTable.getValueAt(j, ycolcell+1).toString()); 
                      String headname = myTable.getColumnName(xcolcell);
                      bardataset.addValue(x, y , z);

                    // System.out.println("X="+x+"Y="+y+"Size="+sizeCol);
                }
         }
         catch(Exception ex){
         //ex.printStackTrace()
         warnme("Please Check/Select X Range Column Data");
         ;}
                   
        
        dataset = new XYSeriesCollection();
	    dataset.addSeries(series1);	
        
        //System.out.println("data"); 
        
 		  }catch (Exception ex) {}			 
  		}
	
	public void readPoint( ) 
  	{
  		try
  		{ 
   		
  		 //For Data X Y get from Table
       int xcolcell = myTable.getSelectedColumn() ;
       int ycolcell = myTable.getSelectedColumn() + 1;
       
       
       int sizeCol = myTable.getSelectedRowCount()  ;
       //System.out.println("CX="+xcolcell+" CY="+ycolcell+"S="+sizeCol);

          try
          {
                  for(int j=0;j<sizeCol;j++)
                {
                      double x = (double)Double.valueOf(myTable.getValueAt(j, xcolcell).toString()) ;
                      double y = (double)Double.valueOf(myTable.getValueAt(j, ycolcell).toString()); 
                   
                         series1.add(x,y);
                     //System.out.println("X="+x+"Y="+y+"Size="+sizeCol);
                }
         }
         catch(Exception ex){
         //ex.printStackTrace()
         warnme("Please Check Your X Y Column Data");
         ;}
                   
        
        dataset = new XYSeriesCollection();
	    dataset.addSeries(series1);	
        
        //System.out.println("data"); 
        
 		  }catch (Exception ex) {}			 
  		}
  		
  		 private DefaultCategoryDataset createBarDataset() {
        
         bardataset = new DefaultCategoryDataset();
               
        return bardataset;
        
    }
    
	private XYDataset createDataset() {
        
        series1 = new XYSeries(" ");
        dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
                 
        return dataset;
        
    }
	
	private JFreeChart createChart(final XYDataset dataset, String chartTitle) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
            chartTitle,      // chart title
            "X",                      // x axis label
            "Y",                      // y axis label
            dataset,                  // data
            PlotOrientation.VERTICAL,
            true,                     // include legend
            true,                     // tooltips
            false                     // urls
        );

        chart.setBorderVisible(true);
         chart.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.blue));
         
        // get a reference to the plot for further customisation...
         
        plot = (XYPlot) chart.getPlot();
        renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        renderer.setDefaultEntityRadius(6);
        plot.setRenderer(renderer);
  
         plot.setRenderer(renderer);
                    
        return chart;
        
    }
    
    private JFreeChart createBarChart(final DefaultCategoryDataset bardataset,String chartTitle) {
        
        // create the chart... ChartFactory.createBarChart if you dont like 3D
        final JFreeChart chart = ChartFactory.createStackedBarChart3D(chartTitle,       // chart title
            "X ",               // domain axis label
            "Y",                  // range axis label
            bardataset,                  // data
            PlotOrientation. VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );
        
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
      plot.getRenderer().setSeriesPaint(0, Color.gray);
      plot.getRenderer().setSeriesPaint(1, Color.lightGray);
      plot.getRenderer().setSeriesPaint(2, Color.darkGray);
      plot.setBackgroundPaint(new GradientPaint(0, 0, Color.white, 0, 1000, Color.yellow));

      plot.getRenderer().setOutlinePaint(Color.WHITE);
             CategoryItemRenderer renderer = plot.getRenderer();
            renderer.setItemLabelsVisible(true);
            renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setBaseItemLabelsVisible(true);
            BarRenderer r = (BarRenderer) renderer;
            //r.setMaximumBarWidth(0.05);
            r.setItemMargin(0.2);
    
 
        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis( );
        rangeAxis.setStandardTickUnits( NumberAxis. createIntegerTickUnits()) ;
        rangeAxis.setLowerMargin(0);
        rangeAxis.setUpperMargin(0);
            
        return chart;
        
    }
    
    public void createImageFile()
    {
    	try {
            ChartUtilities.saveChartAsPNG(new File("chart.png"), chart,100, 80);
        } catch(IOException e) {
            warnme("Failed to render chart as png: "+ e.getMessage());
        }
    	}
    //Report
    protected void executeReport () //throws ReportDefinitionException
  {
  	try
    {
    ReportGenerator generator =ReportGenerator.createInstance();
     
    //= ReportGenerator.getInstance ();    	
  	//ReportGenerator generator = ReportGenerator.getInstance();
  	//warnme("ok");
  	  
  //final URL in = ObjectUtilities.getResourceRelative("goensheet.xml", GoenSheet.class);

	  java.io.File in = new java.io.File("goensheet.xml");
    //  final URL in = file.toURL();
      if (in == null)
      {
      	warnme("test"+in);
        return;
      }
    
      JFreeReport report = generator.parseReport(in);
            
    //JFreeReport report = new JFreeReport();
     report.setName("  Report of "+sourceDir);
  //  report.setPageHeader("");
    
    report.setData(tabModel);
    
    for (int d=1;d<tabModel.getColumnCount();++d)
    {
     TextFieldElementFactory factory = new TextFieldElementFactory();
    factory.setName(tabModel.getColumnName(d-1));
    factory.setAbsolutePosition(new Point2D.Float(0+d*50, 0));
    factory.setMinimumSize(new FloatDimension(140*d, 12));
    factory.setColor(Color.black);
    factory.setHorizontalAlignment(ElementAlignment.LEFT);
    factory.setVerticalAlignment(ElementAlignment.MIDDLE);
    factory.setFieldname(tabModel.getColumnName(d-1));    
    report.getItemBand().addElement(factory.createElement());
    
    /* final ShapeFieldElementFactory shfactory = new ShapeFieldElementFactory();
    shfactory.setName(tabModel.getColumnName(d-1));
    shfactory.setAbsolutePosition(new Point2D.Double(0+d*50, 0));
    shfactory.setMinimumSize(new FloatDimension(140*d, 12));
    shfactory.setColor(Color.black);
    //shfactory.setKeepAspectRatio(true);
    shfactory.setFieldname(tabModel.getColumnName(d-1));
    shfactory.setStroke(new BasicStroke(1));
    shfactory.setShouldDraw(true);
    //shfactory.setShouldFill(true);
    //shfactory.setScale(true);
    report.getItemBand().addElement(shfactory.createElement());
   shfactory.createShapeElement(tabModel.getColumnName(d-1),
                                                 new Point2D.Float(0+d*50, 0),
                                                 Color.black,
                                                 new BasicStroke(1),
                                                 tabModel.getColumnName(d-1),
                                                 true,
                                                 true,
                                                 true,
                                                 true);
    */
    }
    
   
      final PreviewDialog preview = new PreviewDialog(report, this, true);
      preview.getBase().setToolbarFloatable(true);
       preview.pack();
      preview.setVisible(true);
    }
    catch ( Exception e)
  
    {
    	warnme("Failed to generate report "+e);
      Log.error("Failed to generate report ", e);
    }
  }
  public void previewData() 
  
  { 
     //   ObjectUtilities.getResourceRelative("goensheet.xml", GoenSheet.class);

  JFreeReportBoot.getInstance().start();

  	try {
   
    executeReport();
  
      }catch ( Exception ed) {warnme("error"+ed);}
  	}
  
     public void addComponent (final Component component)
  {
    if (component == null)
    {
      throw new NullPointerException("Component must not be null.");
    }
    rows.add(component);
  }

 		public static void main(String argv[]) 
	{
		final GoenSheet gw = new GoenSheet();
 
	}
	// inners clases

///Spash
static class Splash {

	public void showSplash(int duration) {
		JWindow splash = new JWindow();
		JPanel content = (JPanel) splash.getContentPane();

		int width = 324;
		int height = 250;
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width - width) / 2;
		int y = (screen.height - height) / 2;
		splash.setBounds(x, y, width, height);

		// build the splash screen
		JLabel label = new JLabel(new ImageIcon(ClassLoader.getSystemResource("splash.png")));
		JLabel copyrt = new JLabel("Copyright© Javageo.com 2008", JLabel.CENTER);
		copyrt.setFont(new Font("Tahoma", Font.BOLD, 10));

		content.setBackground(SystemColor.controlHighlight);
		
		content.add(label, BorderLayout.CENTER);
		content.add(copyrt, BorderLayout.SOUTH);
		content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		splash.setVisible(true);

		try {
			Thread.sleep(duration);
		}
		catch (Exception e) {
		}

		splash.setVisible(false);
	}
}//toolbar text
class MyTextToolbar extends JToolBar {
   			
	public MyTextToolbar() {
            
            JButton newButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("new.png")));
             newButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		  removeTable();
                      addRow(30);
                      myTable.repaint();                      

                        }
             });
            newButton.setToolTipText("New");

             
            JButton openButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("otabel.png")));
             openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		 if (my_chooser.showOpenDialog(GoenSheet.this) !=  JFileChooser.APPROVE_OPTION) return;
            GoenSheet.this.repaint();
            my_FChoosen = my_chooser.getSelectedFile();
            
            my_OpenFile = my_chooser.getSelectedFile().toString();
            
            openSheetFile(myTable, my_FChoosen);
            
            		//Add to node
		 int newIndex1 = top.getChildCount();
	     myTreeModel.insertNodeInto(new DefaultMutableTreeNode(new IconData(ICON_FILES,null, my_OpenFile)),top,newIndex1);	     
	     myTree.expandRow(newIndex1) ;
	     myTree.setSelectionRow(newIndex1+1) ;
         myTree.repaint();   
         
         setCurrentFile(my_FChoosen);           

               }
             }); 
             
            openButton.setToolTipText("Open");
            
            JButton dataButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("filter.png")));
             dataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            		JFrame frame = new JFrame("Database Connection");
				
			         frame.setContentPane(JPanelSetting(frame)) ;
			         Toolkit kit = Toolkit.getDefaultToolkit();
					 Image image = kit.getImage(ClassLoader.getSystemResource("logo.png"));
					 frame.setIconImage(image);
			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    		frame.setSize(new java.awt.Dimension(360, 240));
    		frame.setLocation((screenSize.width-360)/2,(screenSize.height-240)/2);
    		frame.setVisible(true);   
    		
                        }
             }); 
             
            dataButton.setToolTipText("Load Database");
            
            
            JButton saveButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("save.png")));
             saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            		saveSheetFile(myTable);
            		addNewFile(ReadfnConf.getWorkingDir());
                        }
             }); 
             
            saveButton.setToolTipText("Save As");
            
            JButton cutButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("editcut.png")));
             cutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            		 sheetCell.copyCell();
            		sheetCell.cutCell();
					
                        }
             }); 
             
            cutButton.setToolTipText("Cut");
            
            JButton copyButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("editcopy.png")));
             copyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	sheetCell.copyCell();
                        }
             }); 
             
            copyButton.setToolTipText("Copy");
    
            JButton pasteButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("editpaste.png")));
             pasteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	sheetCell.pasteCell();
                        }
             }); 
             
            pasteButton.setToolTipText("Paste");
            
            JButton boldButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("text_bold.png")));
             boldButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                          	myTable.setFont(new Font(ReadfnConf.getFontName(), Font.BOLD, ReadfnConf.getFontSize()));
	
                        }
             }); 
             
            boldButton.setToolTipText("Bold");
            
            JButton italicButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("text_italic.png")));
            italicButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            myTable.setFont(new Font(ReadfnConf.getFontName(), Font.ITALIC, ReadfnConf.getFontSize()));

                        }
             }); 
             
            italicButton.setToolTipText("Italic");
            
            JButton underLineButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("text_under.png")));
             underLineButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                       myTable.setFont(new Font(ReadfnConf.getFontName(), Font.LAYOUT_LEFT_TO_RIGHT, ReadfnConf.getFontSize()));

                        }
             }); 
             
            underLineButton.setToolTipText("Normal");
                   
            JButton tagnormButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("fonts.png")));
             tagnormButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	setSetting();
                        }
             }); 
             
           tagnormButton.setToolTipText("Set Font");
           
           JButton printButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("print.png")));
             printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PrintFile pfile = new PrintFile(myTable);
                        }
             }); 
             
           printButton.setToolTipText("Print");
           
           JButton previeButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("kview.png")));
             previeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try{
					previewData();
					}catch(Exception ex){warnme("error..."+ex);}
 			 	  
                        }
             }); 
             
           previeButton.setToolTipText("Print Preview");

            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            
            add(newButton);
            add(openButton);
            add(dataButton);
            
            add(saveButton);
            add(cutButton);
            add(copyButton);
            add(pasteButton);
            add(boldButton);
            add(italicButton);
            add(underLineButton);
            add(tagnormButton);
            add(printButton);
            add(previeButton);
	}
}
//toolbar
 
//menu popup
class MyMenuListener implements ActionListener {  
		public void actionPerformed(ActionEvent e) {
			//Righ Clik Menu
 				 if (e.getActionCommand() == "Clear") 
				{
					sheetCell.cutCell();
				
					
   				}
   				if (e.getActionCommand() == "Cut") 
				{   sheetCell.copyCell();
					sheetCell.cutCell();
   				}
				 if (e.getActionCommand() == "Copy") 
				{
					sheetCell.copyCell();
   				}
				if (e.getActionCommand() == "Paste") 
				{
					sheetCell.pasteCell();
  				}
  				if (e.getActionCommand() == "Insert Row") 
				{
					insertRows(myTable.getSelectedRows(),myTable.getSelectedRow());
  				}
  				if (e.getActionCommand() == "Delete Row") 
				{
 					 for(int i=0; i< myTable.getSelectedRowCount();i++)
					 deleteRow(myTable.getSelectedRow());        
					 //I leave for you to delete a column
  					 
			    }
			     if (e.getActionCommand() == "Add Column") 
				{
					 
					addColumn();
  				}
  				if (e.getActionCommand() == "Insert Column") 
				{
					 
					 int col = myTable.getSelectedColumns()[0];
					 insertColumn(myTable,col);
					 					 
  				}
  				
			    if (e.getActionCommand() == "Remove Column") 
				{
				
					removeLastColumn();
			    //	int col = myTable.getSelectedColumns()[0];
				//	myTable.removeColumnSelectionInterval(col, col+1) ;
  				}
			    
			    
				if (e.getActionCommand() == "Select All") 
				{   
					myTable.selectAll();
										
  				}
  				if (e.getActionCommand() == "Select Row") 
				{   
                        myTable.setCellSelectionEnabled(false);
                        myTable.setRowSelectionAllowed(true);
    				}
  				if (e.getActionCommand() == "Select Column") 
				{  
				       myTable.setCellSelectionEnabled(false);
				       myTable.setColumnSelectionAllowed(true);
   				}
   				if (e.getActionCommand() == "Select Cell") 
				{   
 				  
                  myTable.setCellSelectionEnabled(true);
 
   				}
   				if (e.getActionCommand() == "XY Chart") 
				{   
 				  //Make Sure we set to remove from splitme2
 				    if(xychartselect == true)
                   {
                   	
                   	splitMe2.remove(chartPanel);
                   	chart = createChart(xydataset,"XY Line Chart");
                    chartPanel = new ChartPanel(chart);
                    splitMe2.add(chartPanel);
                    splitMe2.validate();
                    createImageFile();
                   	xychartselect = false;
                   	}
                   	
                     //runChartDialog();
                   	int x=series1.getItemCount()-1;
                    series1.delete(0,x);
                    //myTable.sizeColumnsToFit(100) ;
                   readPoint( );
                   chartPanel.setVisible(true);
                   splitMe2.resetToPreferredSizes() ;
                   getContentPane().validate();
                   createImageFile();
                   //
 
   				}
   				
   				if (e.getActionCommand() == "Bar Chart") 
				{   
 				  
                   xychartselect = true;
                     
                    createBarDataset();
					readBarPoint( );
					splitMe2.remove(chartPanel);
					chart = createBarChart(bardataset,"Bar Chart");
                    chartPanel = new ChartPanel(chart);
                    splitMe2.add(chartPanel);
                    splitMe2.validate();
                   //

   				}
   				
 		 
  				if (e.getActionCommand() == "Row Height") 
				{
					String rowHeight=JOptionPane.showInputDialog(null,"Enter Row Height ","GoenSheet",JOptionPane.INFORMATION_MESSAGE);
	              if(!rowHeight.trim().equals("") && myTable.getRowCount()>0)
	              {
	                    int rowH = Integer.parseInt(rowHeight);
	                    myTable.setRowHeight(rowH);
	                    lineTable.setRowHeight(rowH);
	              }
  				}
  				
  				if (e.getActionCommand() == "Column Width") 
				{
					try {
					String rowHeight=JOptionPane.showInputDialog(null,"Column Width","GoenSheet",JOptionPane.INFORMATION_MESSAGE);
					
					int rowH = Integer.parseInt(rowHeight);
 	                    
	               if(!rowHeight.trim().equals("") || rowH > 0 )
	              {
	                    //int rowH = Integer.parseInt(rowHeight);
	                    setAllColumnWidth(rowH);
	                    myTable.sizeColumnsToFit(rowH) ;
	                     
	              }
	              
  				}
  				catch(Exception ex){}
  			}
  			
  			if (e.getActionCommand() == "Rename Column") 
				{
					String renColumn=JOptionPane.showInputDialog(null,"Enter New Column Name","GoenSheet",JOptionPane.INFORMATION_MESSAGE);
	              if(!renColumn.trim().equals("") && myTable.getRowCount()>0)
	              {
	                    int col = myTable.getSelectedColumns()[0];
	                    changeName(myTable,col,renColumn);
	                    //System.out.println("ren"+renColumn+" no"+col);
	                    myTable.addNotify();
	              }
  				}
  				
  			
  			if (e.getActionCommand() == "Print Preview") 
				{
					//warnme("run...");
					try{
					previewData();
					}catch(Exception ex){warnme("error..."+ex);}
  				}
  			
  			
   			}
		}

//extract
class ChartDataDialog extends JDialog 
{
  protected GoenSheet fd_owner;
  
  public ChartDataDialog(GoenSheet owner) 
  {
    super(owner, "Create Chart", false);
    fd_owner = owner;
  
    setSize(250,240);
  
    JPanel content = new JPanel();
    content.setLayout(new BorderLayout());
  
    
    JPanel content1 = new JPanel();
    content1.setLayout(new BoxLayout(content1, BoxLayout.Y_AXIS));
    JLabel label1 = new JLabel("X Data:");
    label1.setForeground(Color.black);
    content1.add(label1);

    final JTextField filenameField = new JTextField(15);
    filenameField.setText("");
   
    content1.add(filenameField);

    JLabel label2 = new JLabel("Y Data:");
    label2.setForeground(Color.black);
    content1.add(label2);

    final JTextField fieldtoDir = new JTextField(15);
    
    fieldtoDir.setText("");
    
    content1.add(fieldtoDir);
      
    content.add("North",content1);
    
    JButton Brosdocdirbutton = new JButton(("Create XY Data"));
	    
	content.add(Brosdocdirbutton);
    
 		ActionListener JarButtonAction = new ActionListener() { 
         public void actionPerformed(ActionEvent e) {
          
              
          }
        };
        
        
        
        ActionListener BrowButtonAction = new ActionListener() { 
         public void actionPerformed(ActionEvent e) {
          
           
          }
        };
        
         Brosdocdirbutton.addActionListener(BrowButtonAction);
        
 		    JButton JarButton= new JButton("Extract File ");
		    JarButton.addActionListener(JarButtonAction);
		    		    
                   
       ActionListener CloseButtonAction = new ActionListener() { 
         public void actionPerformed(ActionEvent e) {
          dispose();
          }
        };
        
        JButton CancelButton = new JButton("Close");
		    CancelButton.addActionListener(CloseButtonAction);
		  
	 JPanel content2 = new JPanel();
	 content2.setLayout(new FlowLayout());
     content2.add(JarButton);         
     content2.add(CancelButton);
            
     content.add("South",content2);     
 
    getContentPane().setLayout(new FlowLayout());
    getContentPane().add(content);
    ((JPanel)getContentPane()).setOpaque(true);

    setVisible(true);
  }
  
  
}
//end dialog xtreact
//icon
class IconCellRenderer 	extends JLabel implements TreeCellRenderer
{
	protected Color m_textSelectionColor;
	protected Color m_textNonSelectionColor;
	protected Color m_bkSelectionColor;
	protected Color m_bkNonSelectionColor;
	protected Color m_borderSelectionColor;

	protected boolean m_selected;

	public IconCellRenderer()
	{
		super();
		m_textSelectionColor = UIManager.getColor("Tree.selectionForeground");
		m_textNonSelectionColor = UIManager.getColor("Tree.textForeground");
		m_bkSelectionColor = UIManager.getColor("Tree.selectionBackground");
		m_bkNonSelectionColor = UIManager.getColor("Tree.textBackground");
		m_borderSelectionColor = UIManager.getColor("Tree.selectionBorderColor");
		setOpaque(false);
	}

	public Component getTreeCellRendererComponent(JTree tree, 
		Object value, boolean sel, boolean expanded, boolean leaf, 
		int row, boolean hasFocus) 
		
	{
		DefaultMutableTreeNode node = 
			(DefaultMutableTreeNode)value;
		Object obj = node.getUserObject();
		setText(obj.toString());

        if (obj instanceof Boolean) setText("Waiting ...");

		if (obj instanceof IconData)
		{
			IconData idata = (IconData)obj;
			if (expanded)
			  setIcon(idata.getExpandedIcon());
			else
			  setIcon(idata.getIcon());
		}
		else
			setIcon(null);
		setFont(tree.getFont());
		setForeground(sel ? m_textSelectionColor : m_textNonSelectionColor);
		setBackground(sel ? m_bkSelectionColor : m_bkNonSelectionColor);
		m_selected = sel;
		return this;
	}
    
	public void paintComponent(Graphics g) 
	{
		Color bColor = getBackground();
		Icon icon = getIcon();

		g.setColor(bColor);
		int offset = 0;
		if(icon != null && getText() != null) 
			offset = (icon.getIconWidth() + getIconTextGap());
		g.fillRect(offset, 0, getWidth() - 1 - offset,getHeight() - 1);
		
		if (m_selected) 
		{
			g.setColor(m_borderSelectionColor);
			g.drawRect(offset, 0, getWidth()-1-offset, getHeight()-1);
		}
		super.paintComponent(g);
    }
}
class IconData
{
	protected Icon   m_icon;
	protected Icon   m_expandedIcon;
	protected Object m_data;
	protected  ImageIcon TEXT_ICON = new ImageIcon(ClassLoader.getSystemResource("kviewshell.png"));
	protected  ImageIcon WEB_ICON = new ImageIcon(ClassLoader.getSystemResource("mozilla.png"));
	protected  ImageIcon IMAGE_ICON = new ImageIcon(ClassLoader.getSystemResource("kpaint.png"));
	protected  ImageIcon APLI_ICON = new ImageIcon(ClassLoader.getSystemResource("launcher.png"));

	public IconData(Icon icon, Object data)
	{
		m_icon = icon;
		m_expandedIcon = null;
		m_data = data;
	}

	public IconData(Icon icon, Icon expandedIcon, Object data)
	{
		m_icon = icon;
		m_expandedIcon = expandedIcon;
		m_data = data;
	}

	public Icon getIcon() 
	{  String name = (String)m_data;

	   if (name.endsWith(".html")|| name.endsWith(".htm"))
			return WEB_ICON;
		else if (name.endsWith(".txt")|| name.endsWith(".htm"))
			return TEXT_ICON;
		else if (name.endsWith(".xlg"))
			return APLI_ICON;
		else if (name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".gif")|| name.endsWith(".bmp")|| name.endsWith(".tif"))
			return IMAGE_ICON;
		else return m_icon;
	}

	public Icon getExpandedIcon() 
	{ 
		return m_expandedIcon!=null ? m_expandedIcon : m_icon;
	}

	public Object getObject() 
	{ 
		return m_data;
	}

	public String toString() 
	{ 
		return m_data.toString();
	}
}
//print file
class PrintFile implements Printable {
    JTable tableView;
	
	public PrintFile(JTable mytabel) {
		tableView = mytabel;
		PrinterJob pj=PrinterJob.getPrinterJob();
		PageFormat pf = pj.pageDialog(pj.defaultPage());
		pj.setPrintable(PrintFile.this,pf);
	 	
		if (pj.printDialog()) {
		
		try { pj.print(); }
		catch (Exception e) 
		{ warnme("Error due to " + e.getClass() + e.getMessage());/* handle exception */ }     
		}     
 	}
	
	public int print(Graphics g, PageFormat pageFormat,int pageIndex) throws PrinterException {
	
	Graphics2D g2 = (Graphics2D) g;
	g2.setColor(Color.black);
	int fontHeight=g2.getFontMetrics().getHeight();
	int fontDesent=g2.getFontMetrics().getDescent();
	
	double pageHeight =	pageFormat.getImageableHeight()-fontHeight;
	
	double pageWidth = pageFormat.getImageableWidth();
	double tableWidth = (double) tableView.getColumnModel().getTotalColumnWidth();
	double scale = 1;
	if (tableWidth >= pageWidth) {
	scale = pageWidth / tableWidth;
	}
	
	double headerHeightOnPage=tableView.getTableHeader().getHeight()*scale;
	double tableWidthOnPage=tableWidth*scale;
	
	double oneRowHeight=(tableView.getRowHeight()+tableView.getRowMargin())*scale;
	int numRowsOnAPage=	(int)((pageHeight-headerHeightOnPage)/oneRowHeight);
	double pageHeightForTable=oneRowHeight*numRowsOnAPage;
	int totalNumPages= (int)Math.ceil((	(double)tableView.getRowCount())/numRowsOnAPage);
	
	if(pageIndex>=totalNumPages) {	return NO_SUCH_PAGE;
	}
	
	g2.translate(pageFormat.getImageableX(),
	pageFormat.getImageableY());
	
	g2.drawString("Page: "+(pageIndex+1),(int)pageWidth/2-35,
	(int)(pageHeight+fontHeight-fontDesent));//bottom center
	
	g2.translate(0f,headerHeightOnPage);
	g2.translate(0f,-pageIndex*pageHeightForTable);
	g2.setClip(0, (int)(pageHeightForTable*pageIndex),(int)Math.ceil(tableWidthOnPage),(int) Math.ceil(pageHeightForTable));
	g2.scale(scale,scale);
	tableView.paint(g2);
	g2.scale(1/scale,1/scale);
	g2.translate(0f,pageIndex*pageHeightForTable);
	g2.translate(0f, -headerHeightOnPage);
	g2.setClip(0, 0,(int) Math.ceil(tableWidthOnPage),
	(int)Math.ceil(headerHeightOnPage));
	g2.scale(scale,scale);
	tableView.getTableHeader().paint(g2);//paint header at top
	return Printable.PAGE_EXISTS;
	} 
	}
//read setting 
class ReadFontConfig {
   String s[] = new String[8] ;

	public ReadFontConfig(String sfile) {
		try {
  		FileReader fr = new FileReader(sfile); 
		BufferedReader br = new BufferedReader(fr);
 		for (int i=0;i<7;i++) {
			s[i]=br.readLine();
			//System.out.println("s"+ i +"=" + s[i]);
		}
		fr.close();
		}catch (IOException e) {
			warnme("Error while reading file, due to " + e.getMessage());
			
			System.exit(1);
		}
 	}
	public String getFontGoen(){ return s[0].substring(9);}
	public String getFontName(){ return s[1].substring(9);}
	public int getFontSize(){ return Integer.valueOf(s[2].substring(9));}
	public int getFontColor(){ return Integer.valueOf(s[3].substring(10));}
	public int getFontBgColor(){ return Integer.valueOf(s[4].substring(12));}
	public String getWorkingDir(){ return s[5].substring(11);}
 	
}
	
//Row line number
public class RowLineNumberTable extends JTable
{
	private JTable mainTable;
	private TableColumn tableColumn = new TableColumn();
	public RowLineNumberTable(JTable table)
	{
		super();
		mainTable = table;
		setAutoCreateColumnsFromModel( false );
		setModel( mainTable.getModel() );
		setSelectionModel( mainTable.getSelectionModel() );
		setAutoscrolls( false );
 
  		addColumn( tableColumn );
		getColumnModel().getColumn(0).setCellRenderer(
			mainTable.getTableHeader().getDefaultRenderer() );
		getColumnModel().getColumn(0).setPreferredWidth(40);
		setPreferredScrollableViewportSize(getPreferredSize());
		setRowHeight(mainTable.getRowHeight());
	    setSelectionBackground(mainTable.getBackground());

 	}
 
	public boolean isCellEditable(int row, int column)
	{
		return false;
	}
 
	public Object getValueAt(int row, int column)
	{
		
		return new Integer(row + 1);
	}
    
 	public Color getBackground()
	{
		return SystemColor.controlHighlight;
	}
	
	public void update(Graphics g)   {
		paint(g);   
		}
 
}
//Excel
class SheetAdapter implements ActionListener
   {
   private String rowstring,value;
   private Clipboard system;
   private StringSelection stsel;
   private JTable jTable1 ;
 public SheetAdapter(JTable myJTable)
   {
       jTable1 = myJTable;
       KeyStroke copy = KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK,false);
       KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK,false);
       KeyStroke cut = KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK,false);
       jTable1.registerKeyboardAction(this,"Copy",copy,JComponent.WHEN_FOCUSED);
       jTable1.registerKeyboardAction(this,"Paste",paste,JComponent.WHEN_FOCUSED);
       jTable1.registerKeyboardAction(this,"Cut",cut,JComponent.WHEN_FOCUSED);
      system = Toolkit.getDefaultToolkit().getSystemClipboard();
   }
 public JTable getJTable() {return jTable1;}
 public void setJTable(JTable jTable1) {this.jTable1=jTable1;}
 
public void copyCell()
{
	StringBuffer sbf=new StringBuffer();
         int numcols=jTable1.getSelectedColumnCount();
         int numrows=jTable1.getSelectedRowCount();
         int[] rowsselected=jTable1.getSelectedRows();
         int[] colsselected=jTable1.getSelectedColumns();
         if (!((numrows-1==rowsselected[rowsselected.length-1]-rowsselected[0] &&
          numrows==rowsselected.length) && (numcols-1==colsselected[colsselected.length-1]-colsselected[0] &&
          numcols==colsselected.length)))
         {
 JOptionPane.showMessageDialog(null, "Invalid Copy Selection","Invalid Copy Selection",JOptionPane.ERROR_MESSAGE);
            return;
         }
         for (int i=0;i<numrows;i++)
         {
            for (int j=0;j<numcols;j++)
            {
sbf.append(jTable1.getValueAt(rowsselected[i],colsselected[j]));
               if (j<numcols-1) sbf.append("\t");
            }
            sbf.append("\n");
         }
         stsel  = new StringSelection(sbf.toString());
         system = Toolkit.getDefaultToolkit().getSystemClipboard();
         system.setContents(stsel,stsel);
	}

public void pasteCell()
{
          int startRow=(jTable1.getSelectedRows())[0];
          int startCol=(jTable1.getSelectedColumns())[0];
          try
          {
             String trstring= (String)(system.getContents(this).getTransferData(DataFlavor.stringFlavor));
             StringTokenizer st1=new StringTokenizer(trstring,"\n");
             for(int i=0;st1.hasMoreTokens();i++)
             {
                rowstring=st1.nextToken();
                StringTokenizer st2=new StringTokenizer(rowstring,"\t");
                for(int j=0;st2.hasMoreTokens();j++)
                {
                   value=(String)st2.nextToken();
                    if (startRow+i< jTable1.getRowCount()  &&
                       startCol+j< jTable1.getColumnCount())                 
                     jTable1.setValueAt(value,startRow+i,startCol+j);
                }
            }
         }
         catch(Exception ex){ 	warnme("Error");
         //ex.printStackTrace();
         }
	
	}

public void cutCell()
{
         int numcols=jTable1.getSelectedColumnCount();
         int numrows=jTable1.getSelectedRowCount();
         int[] rowsselected=jTable1.getSelectedRows();
         int[] colsselected=jTable1.getSelectedColumns();

           try
          {
             for (int i=0;i<numrows;i++)
            {
            for (int j=0;j<numcols;j++)
            {
                  jTable1.setValueAt("",rowsselected[i],colsselected[j]);
             }
            
            }
         }
         catch(Exception ex){	warnme("Error");
         	//ex.printStackTrace();
         	}
	}
public void actionPerformed(ActionEvent e)
   {
      if (e.getActionCommand().compareTo("Copy")==0)
      {
         copyCell();
      }
      if (e.getActionCommand().compareTo("Paste")==0)
      {
          pasteCell();
      }
      if (e.getActionCommand().compareTo("Cut")==0)
      {
          cutCell();
      }
   }
}	

//Export to csv file so Excell/Others can read it
class  ExportertoFile {
 public ExportertoFile() {}
 public void exportTable(JTable table, File file) throws IOException {
  TableModel model = table.getModel();
  FileWriter out = new FileWriter(file);
  
  //Print Header 
  /*for(int i=0; i < model.getColumnCount();i++) {
   out.write(model.getColumnName(i)+",");
  }
  */
  out.write("\n");
 //You can change from \t , ; etc for delimited 
 for(int i=0; i < model.getRowCount();i++){
  for(int j=0;j < model.getColumnCount();j++){
                    if(j==0) {
 			     out.write(table.getValueAt(i,j)+ ",");
			   } else {
   			     out.write(","+table.getValueAt(i,j)+ ",");
 			   }
  }
  out.write("\n");
 }
 out.close();
 System.out.println("write to " + file);
}
}	
//end inner class
}
	



