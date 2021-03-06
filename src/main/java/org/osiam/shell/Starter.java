package org.osiam.shell;

import java.io.File;

import org.osiam.shell.command.ConnectionCommand;
import org.osiam.shell.command.io.AccessTokenConverter;
import org.osiam.shell.command.io.AddressConverter;
import org.osiam.shell.command.io.AddressTypeConverter;
import org.osiam.shell.command.io.DateConverter;
import org.osiam.shell.command.io.EmailConverter;
import org.osiam.shell.command.io.EmailTypeConverter;
import org.osiam.shell.command.io.EntitlementConverter;
import org.osiam.shell.command.io.EntitlementTypeConverter;
import org.osiam.shell.command.io.ExtensionConverter;
import org.osiam.shell.command.io.GroupConverter;
import org.osiam.shell.command.io.ImConverter;
import org.osiam.shell.command.io.ImTypeConverter;
import org.osiam.shell.command.io.NameConverter;
import org.osiam.shell.command.io.PhoneNumberConverter;
import org.osiam.shell.command.io.PhoneNumberTypeConverter;
import org.osiam.shell.command.io.PhotoConverter;
import org.osiam.shell.command.io.PhotoTypeConverter;
import org.osiam.shell.command.io.RoleConverter;
import org.osiam.shell.command.io.RoleTypeConverter;
import org.osiam.shell.command.io.URIConverter;
import org.osiam.shell.command.io.UserConverter;
import org.osiam.shell.command.io.X509CertificateConverter;
import org.osiam.shell.command.io.X509CertificateTypeConverter;

import de.raysha.lib.jsimpleshell.Shell;
import de.raysha.lib.jsimpleshell.ShellBuilder;

public class Starter {

	public static void main(String[] args) throws Exception {
		final Shell shell = ShellBuilder.shell("osiam-shell")
								.setHistoryFile(new File(System.getProperty("user.home"), ".osiamshell_history"))
								.addHandler(new ConnectionCommand())
								.addAuxHandler(new AccessTokenConverter())
								.addAuxHandler(new UserConverter())
								.addAuxHandler(new GroupConverter())
								.addAuxHandler(new AddressTypeConverter())
								.addAuxHandler(new AddressConverter())
								.addAuxHandler(new EmailTypeConverter())
								.addAuxHandler(new EmailConverter())
								.addAuxHandler(new EntitlementTypeConverter())
								.addAuxHandler(new EntitlementConverter())
								.addAuxHandler(new ExtensionConverter())
								.addAuxHandler(new ImTypeConverter())
								.addAuxHandler(new ImConverter())
								.addAuxHandler(new NameConverter())
								.addAuxHandler(new PhoneNumberTypeConverter())
								.addAuxHandler(new PhoneNumberConverter())
								.addAuxHandler(new PhotoTypeConverter())
								.addAuxHandler(new PhotoConverter())
								.addAuxHandler(new RoleTypeConverter())
								.addAuxHandler(new RoleConverter())
								.addAuxHandler(new X509CertificateTypeConverter())
								.addAuxHandler(new X509CertificateConverter())
								.addAuxHandler(new DateConverter())
								.addAuxHandler(new URIConverter())
							.build();
		
		shell.processLine("?help");
		shell.commandLoop();
	}

}
