
package org.jdesktop.j3d.examples.applet3d;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
/**
 *
 * @author jheyson matta cahua
 */
public class Cubo3D implements Runnable{
    
	SimpleUniverse universe = new SimpleUniverse();
	BranchGroup group = new BranchGroup();
	BranchGroup group2 = new BranchGroup();
	ColorCube cube = new ColorCube(0.3);
	ColorCube cube2 = new ColorCube(0.5);
	
	TransformGroup GT = new TransformGroup();
	Transform3D transform = new Transform3D();
	
	TransformGroup GT2 = new TransformGroup();
	Transform3D transform2 = new Transform3D();
	
	double Y=0;
	Thread hilo1 = new Thread(this); // Se declara el hilo

	public Cubo3D(){
	    GT.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // SE SETEA EL GRUPO DE TRANFORMACION
	    GT2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); // SE SETEA EL GRUPO DE TRANFORMACION
	    // como un elemento modificable en tiempo de ejecución
	    //hilo1.start(); // se inicia el hilo
	    Y= Y+0.7; // variable global declarada como double
        transform.rotY(Y); // SE ROTA EN BASE AL EJE Y
        transform2.rotY(Y); // SE ROTA EN BASE AL EJE Y
        
        GT.setTransform(transform); // Se actualiza el grafico
        GT2.setTransform(transform2); // Se actualiza el grafico
        

	    GT.addChild(cube);
	    GT2.addChild(cube2);
	    
	    group.addChild(GT);
	    group.addChild(GT2);
	    universe.getViewingPlatform().setNominalViewingTransform();
	    universe.addBranchGraph(group);
	}
	     
    public static void main(String[] args) {
        new Cubo3D();
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct==hilo1){
            try{
                Y= Y+0.1; // variable global declarada como double
                transform.rotY(Y); // SE ROTA EN BASE AL EJE Y
                GT.setTransform(transform); // Se actualiza el grafico
                Thread.sleep(100); // se espera un tiempo antes de seguir la ejecucion             
            }
            catch (InterruptedException ex){
                Logger.getLogger(Cubo3D.class.getName()).log(Level.SEVERE,null, ex);
            }
        }
    }

}

        
