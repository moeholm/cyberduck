package ch.cyberduck.ui.cocoa;

/*
 *  Copyright (c) 2002 David Kocher. All rights reserved.
 *  http://icu.unizh.ch/~dkocher/
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  Bug fixes, suggestions and comments should be sent to:
 *  dkocher@cyberduck.ch
 */

import com.apple.cocoa.foundation.*;
import com.apple.cocoa.application.*;
import org.apache.log4j.Logger;
import java.util.Observer;
import java.util.Observable;

public class CDHostView extends NSTableView implements Observer {

    private static Logger log = Logger.getLogger(CDHostView.class);

    public CDHostView() {
	super();
    }

    public CDHostView(NSRect frame) {
	super(frame);
    }

    public CDHostView(NSCoder decoder, long token) {
	super(decoder, token);
    }

    public void encodeWithCoder(NSCoder encoder) {
	super.encodeWithCoder(encoder);
    }

    public void awakeFromNib() {
	log.debug("awakeFromNib");
	this.setDelegate(this);
//	this.tableColumnWithIdentifier("HOST").setDataCell(new CDHostCell());;
    }

    public void update(Observable o, Object arg) {
	if(o instanceof Host) {
	    Message msg = (Message)arg;
	    if(msg.getTitle().equals(Message.PROGRESS)) {
	}
    }

    // ----------------------------------------------------------
    // Delegate methods
    // ----------------------------------------------------------

    /**	Returns true to permit aTableView to select the row at rowIndex, false to deny permission.
	* The delegate can implement this method to disallow selection of particular rows.
	*/
    public  boolean tableViewShouldSelectRow( NSTableView aTableView, int rowIndex) {
	return true;
    }

    /**	Returns true to permit aTableView to edit the cell at rowIndex in aTableColumn, false to deny permission.
	*The delegate can implemen this method to disallow editing of specific cells.
	*/
    public boolean tableViewShouldEditLocation( NSTableView view, NSTableColumn tableColumn, int row) {
	return false;
    }

    public void tableViewSelectionDidChange(NSNotification notification) {
	log.debug("tableViewSelectionDidChange");
    }

    public void tableViewWillDisplayCell(NSTableView browserTable, Object cell, NSTableColumn tableColumn, int row) {
	log.debug("tableViewWillDisplayCell");
	/*
	CDHostCell hostCell = (CDHostCell)cell;
	
	log.debug(hostCell.objectValue());

	NSMutableAttributedString attrStr = new NSMutableAttributedString((String)hostCell.objectValue());
	NSRange range = new NSRange(0, attrStr.length());

//	[attrStr addAttribute:NSFontAttributeName value:_font range:range];

	hostCell.setAttributedStringValue(attrStr);
	 */
    }

    // ----------------------------------------------------------
    // Observer interface
    // ----------------------------------------------------------
    
    public void update(Observable o, Object arg) {
	//
    }


    // ----------------------------------------------------------
    // Cell class
    // ----------------------------------------------------------
    
    class CDHostCell extends NSCell {
//	private int MARGIN_X = 0;
	private CDHostView hostView;
	
	public CDHostCell() {
	    super();
	}

	public void drawInteriorWithFrameInView(NSRect cellFrame, NSView controlView) {

	    if(null == hostView) {
		hostView = new CDHostView(cellFrame);
		controlView.addSubview(hostView);
	    }
	    hostView.setFrame(cellFrame);
	    hostView.displayRect(cellFrame);

	    /*
	    log.debug("drawInteriorWithFrameInView");
	    String hostName = "@replace This is a host name";

	    NSImage iconImage = NSImage.imageNamed("server.tiff");
	    log.debug(iconImage.toString());
	    NSPoint iconPoint = new NSPoint(cellFrame.origin().x() + MARGIN_X, cellFrame.origin().y());
	    NSSize iconSize = new NSSize(32, 32);//NSSize.ZeroSize;

	    iconImage.setSize(iconSize);
	    iconImage.compositeToPoint(iconPoint, NSImage.CompositeSourceOver);
	     */




	    /*
	    NSRect pathRect;
	    float w = cellFrame.size().width() - (pathRect.origin().x() - cellFrame.origin().x());
	    float h = cellFrame.size().height();
	    float x = iconSize.width() + MARGIN_X;
	    float y = cellFrame.origin().y();

	    pathRect = new NSRect(x, y, w, h);
//		hostname.drawInRect(pathRect, null);
 */
	}
    }
}
