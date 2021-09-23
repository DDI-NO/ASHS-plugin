/*
 * xnat-template-plugin: org.nrg.xnat.plugins.template.plugin.ASHSPlugin
 * XNAT https://www.xnat.org
 * Copyright (c) 2005-2021, Washington University School of Medicine
 * All Rights Reserved
 *
 * Released under the Simplified BSD.
 */

package org.nrg.xnat.plugins.template.plugin;

import lombok.extern.slf4j.Slf4j;
import org.nrg.config.services.ConfigService;
import org.nrg.framework.annotations.XnatDataModel;
import org.nrg.framework.annotations.XnatPlugin;
import org.nrg.xdat.bean.AshsAshsDataBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@XnatPlugin(value = "ASHS-Plugin", name = "XNAT ASHS Plugin",
            dataModels = {@XnatDataModel(value = AshsAshsDataBean.SCHEMA_ELEMENT_NAME,
                                         singular = "ASHS",
                                         plural = "ASHSs",
                                         code = "ASHS")})

@Slf4j
public class ASHSPlugin {
    public ASHSPlugin() {
        log.info("Creating the ASHS Plugin configuration class");
    }


}
