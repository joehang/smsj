/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is "SMS Library for the Java platform".
 *
 * The Initial Developer of the Original Code is Markus Eriksson.
 * Portions created by the Initial Developer are Copyright (C) 2002
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU General Public License Version 2 or later (the "GPL"), or
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"),
 * in which case the provisions of the GPL or the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of either the GPL or the LGPL, and not to allow others to
 * use your version of this file under the terms of the MPL, indicate your
 * decision by deleting the provisions above and replace them with the notice
 * and other provisions required by the GPL or the LGPL. If you do not delete
 * the provisions above, a recipient may use your version of this file under
 * the terms of any one of the MPL, the GPL or the LGPL.
 *
 * ***** END LICENSE BLOCK ***** */
package org.marre.wap.push;

import java.util.*;
import java.io.*;

import org.marre.xml.*;
import org.marre.xml.wbxml.*;

public class SIPush
{
    private String myUri = null;
    private String myId = null;
    private Date myCreated = null;
    private Date myExpires = null;
    private String myAction = null;

    private String myContent = null;

    public SIPush()
    {
    }

    public static void main(String argv[])
        throws Exception
    {
        WbxmlWriter writer = new WbxmlWriter(new FileOutputStream("si.wbxml"));

        // TODO: DOCTYPE

        writer.setTagTokens(SI_TAG_TOKENS);
        writer.setAttrStartTokens(SI_ATTR_START_TOKENS);
        writer.setAttrValueTokens(SI_ATTR_VALUE_TOKENS);

        writer.addStartElement("si");
        writer.addStartElement("indication", new XmlAttribute[] {
                                new XmlAttribute("href", "http://www.xyz.com/email/123/abc.wml") });
        writer.addCharacters("You have 4 new e-mails");
        writer.addEndTag();
        writer.addEndTag();

        // Write...
        writer.close();
    }

    private byte[] encodeDateTime(Date theDate)
    {
        return null;
/*
If used, the attribute value MUST be expressed in a date/time representation based on [ISO8601] as specified in
[HTML4]. However, SI does not allow use of time zones; the time MUST always be expressed in Co-ordinated
Universal Time (UTC), a 24-hour timekeeping system (indicated by the �Z�). The format is:
YYYY-MM-DDThh:mm:ssZ
Where: YYYY = 4 digit year (�0000� ... �9999�)
MM = 2 digit month (�01�=January, �02�=February ... �12�=December)
DD = 2 digit day (�01�, �02� ... �31�)
hh = 2 digit hour, 24-hour timekeeping system (00 ... 23)
mm = 2 digit minute (�00� ... �59�)
ss = 2 digit second (�00� ... �59�)
Note: T and Z appear literally in the string.
Example: 1999-04-30T06:40:00Z means 6.40 in the morning UTC on the 30th of April 1999.
*/
    }

    private static final String [] SI_TAG_TOKENS = {
        "si",         // 05
        "indication", // 06
        "info",       // 07
        "item",       // 08
    };

    private static final String [] SI_ATTR_START_TOKENS = {
        "action=signal-none",     // 05
        "action=signal-low",      // 06
        "action=signal-medium",   // 07
        "action=signal-high",     // 08
        "action=delete",          // 09
        "created",                // 0A
        "href",                   // 0B
        "href=http://",           // 0C
        "href=http://www.",       // 0D
        "href=https://",          // 0E
        "href=https://www.",      // 0F

        "si-expires",   // 10
        "si-id",        // 11
        "class",        // 12
    };

    private static final String [] SI_ATTR_VALUE_TOKENS = {
        ".com/",   // 85
        ".edu/",   // 86
        ".net/",   // 87
        ".org/",   // 88
    };
}