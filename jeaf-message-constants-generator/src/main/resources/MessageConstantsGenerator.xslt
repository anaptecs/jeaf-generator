<?xml version="1.0" encoding="UTF-8"?>
<!-- 
     Stylesheet defines the transformation of an XML document that has the 
     structure that is defined in DTD MessageData.dtd. Through this templates
     java classes containing constants for all contained messages can be 
     generated.
-->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">




<!-- Define output type of template -->
<xsl:output method="text" version="1.0" encoding="UTF-8" indent="yes"/>




<!-- Define public parameters -->
<xsl:param name="RESOURCE_NAME"/>
	



<!-- 
     Template for root element. This template is the starting point for the 
	 class generation. The template is exceuted due to an build in template 
	 rule
-->
<xsl:template match="Root">package <xsl:value-of select="ClassInfo/@package"/>;
import com.anaptecs.jeaf.xfun.annotations.MessageResource;
/**
 * <xsl:value-of select="ClassInfo/@description"/>
 *
 * @author <xsl:value-of select="ClassInfo/@author"/>
 * @version <xsl:value-of select="ClassInfo/@version"/>
 */
@MessageResource(path = "<xsl:value-of select="$RESOURCE_NAME"/>")
public final class <xsl:value-of select="ClassInfo/@className"/> {
  /**
   * Constant for XML file that contains all messages that are defined within this class.
   */
  private static final String MESSAGE_RESOURCE = "<xsl:value-of select="$RESOURCE_NAME"/>";
  <xsl:apply-templates select="//Message"/>
  <xsl:call-template name="GenerateStaticInitializer">
  <xsl:with-param name="test" select="'Testvalue'"/></xsl:call-template>}
</xsl:template>
	



<!-- 
     Template is used for the generation of a single constant for each message 
	 element. The template is only applied on message elements which have the
	 type INFO.
-->
<xsl:template match="Message[@type='INFO']">
  /**
   * <xsl:value-of select="@description"/>
   */
  <xsl:choose>
  	<xsl:when test="@deprecated = 'TRUE'">@Deprecated</xsl:when>
  </xsl:choose>
  public static final com.anaptecs.jeaf.xfun.api.messages.MessageID <xsl:value-of select="@name"/>;
</xsl:template>
	



<!-- 
     Template is used for the generation of a single constant for each message 
	 element. The template is only applied on message elements which have the
	 type ERROR.
-->
<xsl:template match="Message[@type='ERROR']">
  /**
   * <xsl:value-of select="@description"/>
   */
  <xsl:choose>
  	<xsl:when test="@deprecated = 'TRUE'">@Deprecated</xsl:when>
  </xsl:choose>
  public static final com.anaptecs.jeaf.xfun.api.errorhandling.ErrorCode <xsl:value-of select="@name"/>;
</xsl:template>
	



<!-- 
     Template is used for the generation of a single constant for each message 
	 element. The template is only applied on message elements which have the
	 type ERROR.
-->
<xsl:template match="Message[@type='LOCALIZED_STRING']">
  /**
   * <xsl:value-of select="@description"/>
   */
  <xsl:choose>
  	<xsl:when test="@deprecated = 'TRUE'">@Deprecated</xsl:when>
  </xsl:choose>
  public static final com.anaptecs.jeaf.xfun.api.messages.LocalizedString <xsl:value-of select="@name"/>;
</xsl:template>
	



<!--
     Template generates the static initialzer where all the generated constants 
     are initialized.
-->
<xsl:template name="GenerateStaticInitializer">
  /**
   * Static initializer contains initialization for all generated constants.
   */
  static {
    com.anaptecs.jeaf.xfun.api.messages.MessageRepository lRepository = com.anaptecs.jeaf.xfun.api.XFun.getMessageRepository();
    lRepository.loadResource(MESSAGE_RESOURCE);
    
    // Handle all info messages.
    <xsl:for-each select="//Message[@type='INFO']">
    <xsl:value-of select="@name"/> = lRepository.getMessageID(<xsl:value-of select="@messageID"/>);
    </xsl:for-each>

    // Handle all messages for errors.
    <xsl:for-each select="//Message[@type='ERROR']">
    <xsl:value-of select="@name"/> = lRepository.getErrorCode(<xsl:value-of select="@messageID"/>);
    </xsl:for-each>
    
    // Handle all localized strings.
    <xsl:for-each select="//Message[@type='LOCALIZED_STRING']">
    <xsl:value-of select="@name"/> = lRepository.getLocalizedString(<xsl:value-of select="@messageID"/>);
    </xsl:for-each>
  }
  
  /**
   * Constructor is private to ensure that no instances of this class will be created.
   */
  private <xsl:value-of select="ClassInfo/@className"/>() {
    // Nothing to do.
  }
</xsl:template>



<!--
     End of stylesheet.
-->
</xsl:stylesheet>
 