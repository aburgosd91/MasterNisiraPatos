package com.scrollabledesktop;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JToggleButton;

/**
 * This class provides the resizable toolbar for the scrollable desktop.
 *
 * @author <a href="mailto:tessier@gabinternet.com">Tom Tessier</a>
 * @version 1.0 11-Aug-2001
 */

public class DesktopResizableToolBar extends ResizableToolBar implements
		DesktopConstants, ActionListener {

	private DesktopMediator desktopMediator;

	/**
	 * creates the DesktopResizableToolBar object
	 *
	 * @param desktopMediator
	 *            a reference to the DesktopMediator object
	 */
	public DesktopResizableToolBar(DesktopMediator desktopMediator) {

		super(MINIMUM_BUTTON_WIDTH, MAXIMUM_BUTTON_WIDTH);

		this.desktopMediator = desktopMediator;

		// prepare test button
		BaseToggleButton testButton = new BaseToggleButton("test");

		// now add a button-sized separator to the toolBar so that
		// the layout manager can properly setup
		addSeparator(new Dimension(0, testButton.getMinimumSize().height));

	}

	/**
	 * creates a BaseToggleButton and adds it to the toolbar
	 *
	 * @param title
	 *            the title of the toggle button
	 *
	 * @return the toggle button that was created
	 */
	public BaseToggleButton add(String title) {

		BaseToggleButton toolButton = new BaseToggleButton(" " + title + " ");
		toolButton.addActionListener(this);

		super.add(toolButton);

		return toolButton;

	}

	/**
	 * propogates actionPerformed button event to DesktopMediator
	 *
	 * @param e
	 *            the ActionEvent to propogate
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		desktopMediator.actionPerformed(e);
	}

	public void disableButtons() {
		JToggleButton b = null;
		Enumeration e = getElements();
		while (e.hasMoreElements()) {
			b = (JToggleButton) e.nextElement();
			b.setEnabled(false);
		}
	}

	public void enableButtons() {
		JToggleButton b = null;
		Enumeration e = getElements();
		while (e.hasMoreElements()) {
			b = (JToggleButton) e.nextElement();
			b.setEnabled(true);
		}
	}
}