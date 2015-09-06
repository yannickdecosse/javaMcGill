/*
 * Name:		Yannick Decosse
 * Course ID:	CCCS-301-751 - Programming Techniques 2
 * McGill ID:	260551160
 * Instructor: 	Joseph Vybihal
 * Date:		March 27, 2015
 * 
 * Subject:		Assignment 4: Exceptions & File IO
 * Details:		Working with FIle IO and Exceptions for validation
 * File name:	EmptyException.java
 * Purpose:		Creating custom Exception class for empty text file
 * IDE:			Eclipse v.Luna Standard Edition
 * 
 */

package Question5;

public class EmptyException extends Exception
{
	private String message;

	private static final long serialVersionUID = 1L;

	public EmptyException()	{}

	public EmptyException(String message)
	{
		super(message);
		this.message = message;
	}

	public EmptyException(Throwable cause)
	{
		super(cause);
	}

	public EmptyException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public EmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	@Override
    public String toString()
	{
        return message;
    }
 
    @Override
    public String getMessage()
    {
        return message;
    }
}
