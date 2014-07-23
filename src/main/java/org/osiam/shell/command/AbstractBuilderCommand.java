package org.osiam.shell.command;

import de.raysha.lib.jsimpleshell.annotation.Command;
import de.raysha.lib.jsimpleshell.exception.ExitException;

/**
 * This abstract class contains only a command to cancel the current build process.
 * 
 * @author rainu
 */
public abstract class AbstractBuilderCommand<ToBuild> {
	private boolean isCanceled = false;
	
	@Command(description = "Cancel the current process.")
	public void cancel() throws ExitException{
		this.isCanceled = true;
		throw new ExitException("Process was canceled!");
	}
	
	@Command(description = "Confirms the current process.")
	public void confirm() throws ExitException{
		throw new ExitException();
	}
	
	public boolean isCanceled() {
		return isCanceled;
	}

	/**
	 * Build the instance. If the process was canceled by the user, null will returned.
	 * 
	 * @return The instance of null if the user canceled the process.
	 */
	public ToBuild build(){
		if(isCanceled()) return null;
		
		return _build();
	}

	protected abstract ToBuild _build();
}
