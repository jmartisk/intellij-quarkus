/*******************************************************************************
 * Copyright (c) 2023 Red Hat Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Red Hat Inc. - initial API and implementation
 *******************************************************************************/
package com.redhat.microprofile.psi.quarkus;

import com.intellij.openapi.module.Module;
import com.redhat.devtools.intellij.MavenModuleImportingTestCase;

import java.io.File;

/**
 * Base class to import Quarkus maven project.
 *
 */
public abstract class QuarkusMavenModuleImportingTestCase extends MavenModuleImportingTestCase {

    protected Module loadMavenProject(String projectName) throws Exception {
        return createMavenModule(new File("projects/quarkus/projects/maven/" + projectName));
    }
}
