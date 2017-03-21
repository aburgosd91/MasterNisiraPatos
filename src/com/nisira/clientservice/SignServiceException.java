
package com.nisira.clientservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SignServiceException" type="{http://core.sign.nisira.com}Exception" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "signServiceException"
})
@XmlRootElement(name = "SignServiceException")
public class SignServiceException {

    @XmlElementRef(name = "SignServiceException", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<Exception> signServiceException;

    /**
     * Obtiene el valor de la propiedad signServiceException.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Exception }{@code >}
     *     
     */
    public JAXBElement<Exception> getSignServiceException() {
        return signServiceException;
    }

    /**
     * Define el valor de la propiedad signServiceException.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Exception }{@code >}
     *     
     */
    public void setSignServiceException(JAXBElement<Exception> value) {
        this.signServiceException = value;
    }

}
