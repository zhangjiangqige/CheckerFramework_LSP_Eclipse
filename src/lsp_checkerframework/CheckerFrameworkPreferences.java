package lsp_checkerframework;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;


public class CheckerFrameworkPreferences extends PreferencePage implements
IWorkbenchPreferencePage, SelectionListener, ModifyListener {
	
//	protected Control createContents(Composite parent) {
//		Composite composite = new Composite(parent, SWT.NONE);
//		composite.setLayoutData(new GridData(4, 4, true, true));
//		composite.setLayout(new GridLayout());
//		return composite;
//	}
//
//	@Override
//	public void init(IWorkbench workbench) {
//
//	}
//	
//	@Override
//	public void modifyText(ModifyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void widgetSelected(SelectionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void widgetDefaultSelected(SelectionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
	
	
	
	
	private Button radioButton1;

	private Button radioButton2;

	private Button radioButton3;

	private Button checkBox1;

	private Button checkBox2;

	private Button checkBox3;

	private Text textField;

	/**
	 * Creates an new checkbox instance and sets the default
	 * layout data.
	 *
	 * @param group  the composite in which to create the checkbox
	 * @param label  the string to set into the checkbox
	 * @return the new checkbox
	 */
	private Button createCheckBox(Composite group, String label) {
		Button button = new Button(group, SWT.CHECK | SWT.LEFT);
		button.setText(label);
		button.addSelectionListener(this);
		GridData data = new GridData();
		button.setLayoutData(data);
		return button;
	}

	/**
	 * Creates composite control and sets the default layout data.
	 *
	 * @param parent  the parent of the new composite
	 * @param numColumns  the number of columns for the new composite
	 * @return the newly-created coposite
	 */
	private Composite createComposite(Composite parent, int numColumns) {
		Composite composite = new Composite(parent, SWT.NULL);

		//GridLayout
		GridLayout layout = new GridLayout();
		layout.numColumns = numColumns;
		composite.setLayout(layout);

		//GridData
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);
		return composite;
	}

	/** (non-Javadoc)
	 * Method declared on PreferencePage
	 */
	protected Control createContents(Composite parent) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
				"HELP");

		//composite_textField << parent
		Composite composite_textField = createComposite(parent, 2);
		createLabel(composite_textField, "TEXT FIELD"); //$NON-NLS-1$
		textField = createTextField(composite_textField);
		createPushButton(composite_textField, "TEXT FIELD"); //$NON-NLS-1$

		//composite_tab << parent
		Composite composite_tab = createComposite(parent, 2);
		createLabel(composite_tab, "Radio_Button_Options"); //$NON-NLS-1$

		//
		tabForward(composite_tab);
		//radio button composite << tab composite
		Composite composite_radioButton = createComposite(composite_tab, 1);
		radioButton1 = createRadioButton(composite_radioButton, "Radio_button_1"); //$NON-NLS-1$
		radioButton2 = createRadioButton(composite_radioButton, "Radio_button_2"); //$NON-NLS-1$
		radioButton3 = createRadioButton(composite_radioButton, "Radio_button_3"); //$NON-NLS-1$

		//composite_tab2 << parent
		Composite composite_tab2 = createComposite(parent, 2);
		createLabel(composite_tab2, "Check_Box_Options"); //$NON-NLS-1$

		//
		tabForward(composite_tab2);
		//composite_checkBox << composite_tab2
		Composite composite_checkBox = createComposite(composite_tab2, 1);
		checkBox1 = createCheckBox(composite_checkBox, "Check_box_1"); //$NON-NLS-1$
		checkBox2 = createCheckBox(composite_checkBox, "Check_box_2"); //$NON-NLS-1$
		checkBox3 = createCheckBox(composite_checkBox, "Check_box_3"); //$NON-NLS-1$

		initializeValues();

		//font = null;
		return new Composite(parent, SWT.NULL);
	}

	/**
	 * Utility method that creates a label instance
	 * and sets the default layout data.
	 *
	 * @param parent  the parent for the new label
	 * @param text  the text for the new label
	 * @return the new label
	 */
	private Label createLabel(Composite parent, String text) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(text);
		GridData data = new GridData();
		data.horizontalSpan = 2;
		data.horizontalAlignment = GridData.FILL;
		label.setLayoutData(data);
		return label;
	}

	/**
	 * Utility method that creates a push button instance
	 * and sets the default layout data.
	 *
	 * @param parent  the parent for the new button
	 * @param label  the label for the new button
	 * @return the newly-created button
	 */
	private Button createPushButton(Composite parent, String label) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(label);
		button.addSelectionListener(this);
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		button.setLayoutData(data);
		return button;
	}

	/**
	 * Utility method that creates a radio button instance
	 * and sets the default layout data.
	 *
	 * @param parent  the parent for the new button
	 * @param label  the label for the new button
	 * @return the newly-created button
	 */
	private Button createRadioButton(Composite parent, String label) {
		Button button = new Button(parent, SWT.RADIO | SWT.LEFT);
		button.setText(label);
		button.addSelectionListener(this);
		GridData data = new GridData();
		button.setLayoutData(data);
		return button;
	}

	/**
	 * Create a text field specific for this application
	 *
	 * @param parent  the parent of the new text field
	 * @return the new text field
	 */
	private Text createTextField(Composite parent) {
		Text text = new Text(parent, SWT.SINGLE | SWT.BORDER);
		text.addModifyListener(this);
		GridData data = new GridData();
		data.horizontalAlignment = GridData.FILL;
		data.grabExcessHorizontalSpace = true;
		data.verticalAlignment = GridData.CENTER;
		data.grabExcessVerticalSpace = false;
		text.setLayoutData(data);
		return text;
	}

	/** 
	 * The <code>ReadmePreferencePage</code> implementation of this
	 * <code>PreferencePage</code> method 
	 * returns preference store that belongs to the our plugin.
	 * This is important because we want to store
	 * our preferences separately from the workbench.
	 */
	protected IPreferenceStore doGetPreferenceStore() {
		return LSPCheckerFrameworkPlugin.getDefault().getPreferenceStore();
	}

	/* (non-Javadoc)
	 * Method declared on IWorkbenchPreferencePage
	 */
	public void init(IWorkbench workbench) {
		setPreferenceStore(LSPCheckerFrameworkPlugin.getDefault().getPreferenceStore());
	}

	/**
	 * Initializes states of the controls using default values
	 * in the preference store.
	 */
	private void initializeDefaults() {
		IPreferenceStore store = getPreferenceStore();
		checkBox1.setSelection(store
				.getDefaultBoolean("BOOLEAN 1"));
		checkBox2.setSelection(store
				.getDefaultBoolean("BOOLEAN 2"));
		checkBox3.setSelection(store
				.getDefaultBoolean("BOOLEAN 3"));

		radioButton1.setSelection(false);
		radioButton2.setSelection(false);
		radioButton3.setSelection(false);
		int choice = store.getDefaultInt("CHOICE");
		switch (choice) {
		case 1:
			radioButton1.setSelection(true);
			break;
		case 2:
			radioButton2.setSelection(true);
			break;
		case 3:
			radioButton3.setSelection(true);
			break;
		}
		textField.setText(store.getDefaultString("TEXT"));
	}

	/**
	 * Initializes states of the controls from the preference store.
	 */
	private void initializeValues() {
		IPreferenceStore store = getPreferenceStore();
		checkBox1.setSelection(store.getBoolean("BOOLEAN 1"));
		checkBox2.setSelection(store.getBoolean("BOOLEAN 2"));
		checkBox3.setSelection(store.getBoolean("BOOLEAN 3"));

		int choice = store.getInt("CHOICE");
		switch (choice) {
		case 1:
			radioButton1.setSelection(true);
			break;
		case 2:
			radioButton2.setSelection(true);
			break;
		case 3:
			radioButton3.setSelection(true);
			break;
		}
		textField.setText(store.getString("TEXT"));
	}

	/** (non-Javadoc)
	 * Method declared on ModifyListener
	 */
	public void modifyText(ModifyEvent event) {
		//Do nothing on a modification in this example
	}

	/* (non-Javadoc)
	 * Method declared on PreferencePage
	 */
	protected void performDefaults() {
		super.performDefaults();
		initializeDefaults();
	}

	/* (non-Javadoc)
	 * Method declared on PreferencePage
	 */
	public boolean performOk() {
		storeValues();
		LSPCheckerFrameworkPlugin.getDefault().savePluginPreferences();
		return true;
	}

	/**
	 * Stores the values of the controls back to the preference store.
	 */
	private void storeValues() {
		IPreferenceStore store = getPreferenceStore();
		store.setValue("BOOLEAN 1", checkBox1.getSelection());
		store.setValue("BOOLEAN 2", checkBox2.getSelection());
		store.setValue("BOOLEAN 3", checkBox3.getSelection());

		int choice = 1;

		if (radioButton2.getSelection())
			choice = 2;
		else if (radioButton3.getSelection())
			choice = 3;

		store.setValue("CHOCIE", choice);
		store.setValue("TEXT", textField.getText());
	}

	/**
	 * Creates a tab of one horizontal spans.
	 *
	 * @param parent  the parent in which the tab should be created
	 */
	private void tabForward(Composite parent) {
		Label vfiller = new Label(parent, SWT.LEFT);
		GridData gridData = new GridData();
		gridData = new GridData();
		gridData.horizontalAlignment = GridData.BEGINNING;
		gridData.grabExcessHorizontalSpace = false;
		gridData.verticalAlignment = GridData.CENTER;
		gridData.grabExcessVerticalSpace = false;
		vfiller.setLayoutData(gridData);
	}

	/** (non-Javadoc)
	 * Method declared on SelectionListener
	 */
	public void widgetDefaultSelected(SelectionEvent event) {
		//Handle a default selection. Do nothing in this example
	}

	/** (non-Javadoc)
	 * Method declared on SelectionListener
	 */
	public void widgetSelected(SelectionEvent event) {
		//Do nothing on selection in this example;
	}
}