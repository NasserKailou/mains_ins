/**
 * Script pour le dashboard de la page d'accueil
 * Doit être chargé APRÈS jQuery, Highcharts et DataTables
 */

// Attendre que le DOM soit complètement chargé
$(document).ready(function() {
    
    console.log('Dashboard script chargé');
    
    // Vérifier que jQuery est chargé
    if (typeof jQuery === 'undefined') {
        console.error('jQuery n\'est pas chargé!');
        return;
    }
    
    // Vérifier que Highcharts est chargé
    if (typeof Highcharts === 'undefined') {
        console.error('Highcharts n\'est pas chargé!');
        return;
    }
    
    // Vérifier que les conteneurs existent (page dashboard)
    if ($('#chartStructure').length === 0 && $('#chartPrestation').length === 0) {
        console.log('Pas de graphiques dashboard sur cette page');
        return;
    }
    
    console.log('Initialisation du dashboard...');
    
    // Récupérer les données depuis les attributs data
    var structureDataElement = $('#dashboardStructureData');
    var prestationDataElement = $('#dashboardPrestationData');
    
    if (structureDataElement.length === 0 || prestationDataElement.length === 0) {
        console.error('Éléments de données manquants');
        return;
    }
    
    // Parser les données JSON
    var structureData = [];
    var prestationData = [];
    
    try {
        var structureJson = structureDataElement.text();
        var prestationJson = prestationDataElement.text();
        
        if (structureJson) {
            structureData = JSON.parse(structureJson);
            console.log('Structure Data chargées:', structureData);
        }
        
        if (prestationJson) {
            prestationData = JSON.parse(prestationJson);
            console.log('Prestation Data chargées:', prestationData);
        }
    } catch(e) {
        console.error('Erreur parsing JSON:', e);
        return;
    }
    
    // Initialiser DataTables pour les tableaux
    if ($.fn.DataTable) {
        $('#tableStructure, #tablePrestation').DataTable({
            "language": {
                "url": "//cdn.datatables.net/plug-ins/1.10.24/i18n/French.json"
            },
            "order": [[1, "desc"]],
            "pageLength": 10,
            "responsive": true
        });
        console.log('DataTables initialisés');
    }
    
    // Configuration responsive pour Highcharts
    var responsiveOptions = {
        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        enabled: false
                    }
                }
            }]
        }
    };
    
    // Graphique Règlements par Structure
    if ($('#chartStructure').length > 0 && structureData.length > 0) {
        try {
            Highcharts.chart('chartStructure', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: 'Répartition des Règlements par Structure'
                },
                xAxis: {
                    type: 'category',
                    labels: {
                        rotation: -45,
                        style: {
                            fontSize: '11px'
                        }
                    }
                },
                yAxis: {
                    title: {
                        text: 'Montant (FCFA)'
                    }
                },
                legend: {
                    enabled: false
                },
                tooltip: {
                    pointFormat: '<b>{point.y:,.0f} FCFA</b>'
                },
                series: [{
                    name: 'Montant',
                    data: structureData,
                    dataLabels: {
                        enabled: false
                    },
                    colorByPoint: true
                }],
                responsive: responsiveOptions.responsive
            });
            console.log('Graphique Structure créé');
        } catch(e) {
            console.error('Erreur création graphique Structure:', e);
        }
    } else {
        console.warn('Pas de données pour le graphique Structure');
    }
    
    // Graphique Règlements par Type de Prestation
    if ($('#chartPrestation').length > 0 && prestationData.length > 0) {
        try {
            Highcharts.chart('chartPrestation', {
                chart: {
                    type: 'pie'
                },
                title: {
                    text: 'Répartition par Type de Prestation'
                },
                tooltip: {
                    pointFormat: '<b>{point.y:,.0f} FCFA</b> ({point.percentage:.1f}%)'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: true,
                            format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                            style: {
                                fontSize: '11px'
                            }
                        }
                    }
                },
                series: [{
                    name: 'Montant',
                    colorByPoint: true,
                    data: prestationData
                }],
                responsive: responsiveOptions.responsive
            });
            console.log('Graphique Prestation créé');
        } catch(e) {
            console.error('Erreur création graphique Prestation:', e);
        }
    } else {
        console.warn('Pas de données pour le graphique Prestation');
    }
    
    console.log('Dashboard initialisé avec succès!');
});
