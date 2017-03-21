
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
 *         &lt;element name="ticket" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idempresa" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="claveempresa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idusuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="claveusuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ticket",
    "idempresa",
    "claveempresa",
    "idusuario",
    "claveusuario"
})
@XmlRootElement(name = "consulta")
public class Consulta {

    @XmlElementRef(name = "documento", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> documento;
    @XmlElementRef(name = "ticket", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ticket;
    protected int idempresa;
    @XmlElementRef(name = "claveempresa", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> claveempresa;
    @XmlElementRef(name = "idusuario", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> idusuario;
    @XmlElementRef(name = "claveusuario", namespace = "http://core.sign.nisira.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> claveusuario;

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
     * Obtiene el valor de la propiedad ticket.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTicket() {
        return ticket;
    }

    /**
     * Define el valor de la propiedad ticket.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTicket(JAXBElement<String> value) {
        this.ticket = value;
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

}
