/*
    SMS Library for the Java platform
    Copyright (C) 2002  Markus Eriksson

    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU Lesser General Public
    License as published by the Free Software Foundation; either
    version 2.1 of the License, or (at your option) any later version.

    This library is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
    Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public
    License along with this library; if not, write to the Free Software
    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
package org.marre.sms;

public abstract class SmsAbstractMessage implements SmsMessage
{
    protected byte myDcs = 0x00;

    /**
     * Returns the DCS field
     * <p>
     * Use org.marre.sms.util.SmsDcsUtil to parse the information in the
     * DCS field.
     *
     * @return the DCS
     */
    public byte getDataCodingScheme()
    {
        return myDcs;
    }

    /**
     * Set the DCS field
     *
     * @param theDcs The new DCS field
     */
    public void setDataCodingScheme(byte theDcs)
    {
        myDcs = theDcs;
    }
}