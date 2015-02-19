package com.redondo.email_cmd_sender;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 * Email Sender for snap finance
 */
public class EmailNotifier
{

    public static void main( final String[] args ) throws AddressException,
            MessagingException
    {

        CommandlineOptions commandlineOptions = new CommandlineOptions();
        CmdLineParser parser = new CmdLineParser( commandlineOptions );

        EmailHelper emailHelper = new EmailHelper();
        try
        {
            parser.parseArgument( args );
            emailHelper.configureServerProperties( commandlineOptions.getPropertiesPath() );
            emailHelper.createEmailMessage( commandlineOptions.getMail().split( ";" ),
                    commandlineOptions.getSubject(), commandlineOptions.getContent(),
                    commandlineOptions.getAttachpath() );
            emailHelper.sendEmail();
        }
        catch ( CmdLineException e )
        {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }

    }

}
