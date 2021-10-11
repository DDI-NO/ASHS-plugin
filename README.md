# Automatic Segmentation of Hippocampal Subfields (ASHS) XNAT Plugin

This repository provides the source code to build the ASHS XNAT plugin. The plugin extends XNAT to enable storing and managing ASHS results as image assessors.

## Data model
As any XNAT plugin, the data model is defined with the ashs.xsd schema. The main data structure is `ashsData`, having the following elements:

| Element | Description     |
| :------------- | :------------- |
| ashs_version   | The ASHS version that was run |
| atlas          | The atlas employed |
| T1             | The scan ID of the input T1 |
| T2             | The scan ID of the input T2 |
| QC             | QC status |
| ICV            | Measured Intracranial volume |
| measures       | Complex element to enclose region measures |

`measures` enclose the raw and heur measurements with two children: `volumetric_raw` and `volumetric_heur`. Both allow an unbounded number of `region` elements, which store `NSlices` and `Volume`values as elements, and the region `name` and `hemisphere` as attributes.
#### XML tree

```
ashsData
|_ashs_version
|_atlas
|_T1
|_T2
|_QC
|_ICV
|_measures
  |_volumetric_raw
  |  |_regions
  |    |_raw_region(name, hemisphere)
  |      |_NSlices
  |      |_Volume
  |_volumetric_heur
    |_regions
      |_heur_region(name, hemisphere)
        |_NSlices
        |_Volume
```
#### Database constraints
For a given experiment (ASHS result), the region measurements are supposed to be unique. This is constrained by the region `name` attribute, acting as an ID. E.g. it is not possible to store two entries of
```XML
<ashs:raw_region name="Left_Anterior_hippocampus" hemisphere="left">
  ...
```
### Display file
We have implemented display fields for the regions defined in the `ashsT1_atlas_upennpmc_07202018` atlas. These are obtained from a specific database view that looks for (Left|Right)_region_name.

## Report screen
The plugin provides a report screen to quickly inspect the measurement results. It has a main summary section for global ASHS information and tabs for raw and heur measurements. The tables are built dynamically, retrieving the array of regions and display a row per region found.  
