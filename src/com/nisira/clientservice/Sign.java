
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
 *         &lt;element name="documento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="xml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idempresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="claveempresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idusuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="claveusuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="adicional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "documento",
    "xml",
    "idempresa",
    "claveempresa",
    "idusuario",
    "claveusuario",
    "adicional"
})
@XmlRootElement(name = "sign")
public class Sign {

    @XmlElementRef(name = "documento", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documento;
    @XmlElementRef(name = "xml", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> xml;
    protected int idempresa;
    @XmlElementRef(name = "claveempresa", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> claveempresa;
    @XmlElementRef(name = "idusuario", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idusuario;
    @XmlElementRef(name = "claveusuario", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> claveusuario;
    @XmlElementRef(name = "adicional", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> adicional;

    /**
     * Obtiene el valor de la propiedad documento.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDocumento() {
        return documento;
    }

    /**
     * Define el valor de la propiedad documento.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDocumento(JAXBElement<String> value) {
        this.documento = value;
    }

    /**
     * Obtiene el valor de la propiedad xml.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getXml() {
        return xml;
    }

    /**
     * Define el valor de la propiedad xml.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setXml(JAXBElement<String> value) {
        this.xml = value;
    }

    /**
     * Obtiene el valor de la propiedad idempresa.
     * 
     */
    public int getIdempresa() {
        return idempresa;
    }

    /**
     * Define el valor de la propiedad idempresa.
     * 
     */
    public void setIdempresa(int value) {
        this.idempresa = value;
    }

    /**
     * Obtiene el valor de la propiedad claveempresa.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getClaveempresa() {
        return claveempresa;
    }

    /**
     * Define el valor de la propiedad claveempresa.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setClaveempresa(JAXBElement<String> value) {
        this.claveempresa = value;
    }

    /**
     * Obtiene el valor de la propiedad idusuario.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdusuario() {
        return idusuario;
    }

    /**
     * Define el valor de la propiedad idusuario.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdusuario(JAXBElement<String> value) {
        this.idusuario = value;
    }

    /**
     * Obtiene el valor de la propiedad claveusuario.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getClaveusuario() {
        return claveusuario;
    }

    /**
     * Define el valor de la propiedad claveusuario.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setClaveusuario(JAXBElement<String> value) {
        this.claveusuario = value;
    }

    /**
     * Obtiene el valor de la propiedad adicional.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAdicional() {
        return adicional;
    }

    /**
     * Define el valor de la propiedad adicional.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAdicional(JAXBElement<String> value) {
        this.adicional = value;
    }

}
