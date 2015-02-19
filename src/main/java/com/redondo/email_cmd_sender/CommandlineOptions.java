package com.redondo.email_cmd_sender;

import org.kohsuke.args4j.Option;

public class CommandlineOptions
{

    @Option( name = "-mail", usage = "Sets the mail" )
    public String mail;

    @Option( name = "-attach", usage = "Sets a attach path to file" )
    public String attachpath;

    @Option( name = "-content", usage = "Sets a content" )
    public String content;

    @Option( name = "-subject", usage = "Sets a subject" )
    public String subject;

    @Option( name = "-properties", usage = "Properties path" )
    public String propertiesPath;

    public String getMail()
    {
        return this.mail;
    }

    public void setMail( final String mail )
    {
        this.mail = mail;
    }

    public String getAttachpath()
    {
        return this.attachpath;
    }

    public void setAttachpath( final String attachpath )
    {
        this.attachpath = attachpath;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent( final String content )
    {
        this.content = content;
    }

    public String getSubject()
    {
        return this.subject;
    }

    public void setSubject( final String subject )
    {
        this.subject = subject;
    }
    
    public String getPropertiesPath()
    {
        return propertiesPath;
    }

    
    public void setPropertiesPath( String propertiesPath )
    {
        this.propertiesPath = propertiesPath;
    }
    
    

}
